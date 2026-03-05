package server.service.impl;

import com.basketball.bo.user.UserLoginData;
import com.basketball.bo.user.UserLoginVerifyData;
import com.basketball.context.BaseContext;
import com.basketball.dto.user.UserLoginDTO;
import com.basketball.enums.redis.RedisPrefix;
import com.basketball.exception.BaseException;
import com.basketball.exception.user.UserException;
import com.basketball.util.JwtUtil;
import com.basketball.vo.user.CurrentUserDataVO;
import com.basketball.vo.user.UserLoginVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import server.mapper.UserMapper;
import server.service.UserService;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Service
public class UserImpl implements UserService {

    private final UserMapper userMapper;

    private final RedisTemplate<String,String> redisTemplate;

    private final ObjectMapper objectMapper;

    @Value("${jwt.secretKey}")
    private String jwtSecretKey;

    @Value("${jwt.expiration}")
    private Long jwtExpiration;
    @Override
    public UserLoginVO login(UserLoginDTO dto) throws JsonProcessingException {
        // 查询用户是否存在
        UserLoginVerifyData user = userMapper.getUserLoginDataByAccount(dto.getTelephone());
        if (user == null) {
            throw new UserException("用户不存在");
        }
        if (!user.getPassword().equals(dto.getPassword())) {
            throw new BaseException("密码错误");
        }

        // 设置载荷内容
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", user.getId());

        // 根据 rememberMe 选择过期时间
        long ttlMillis;
        if (Boolean.TRUE.equals(dto.getRememberMe())) {
            // 记住我：7天
            ttlMillis = 7 * 24 * 3600 * 1000L;
        } else {
            // 不记住我：1小时（和你原来的一致）
            ttlMillis = 3600 * 1000L;
        }
        // 生成token
        String token = JwtUtil.createJWT(
                jwtSecretKey,
                ttlMillis,
                claims
        );

        // 返回用户信息
        UserLoginData userLoginData = new UserLoginData();
        userLoginData.setId(user.getId());
        userLoginData.setToken(token);
        // Redis 缓存也设置相同的过期时间
        redisTemplate.opsForValue().set(
                RedisPrefix.USER_LOGIN_DATA.getPrefix() + user.getId(),
                objectMapper.writeValueAsString(userLoginData),
                ttlMillis,
                TimeUnit.MILLISECONDS
        );

        return UserLoginVO.builder()
                .id(user.getId())
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .token(token)
                .build();
    }

    @Override
    public CurrentUserDataVO getCurrentUserData() {
        return userMapper.getUserBasicDataById(BaseContext.getCurrentUserId());
    }
}
