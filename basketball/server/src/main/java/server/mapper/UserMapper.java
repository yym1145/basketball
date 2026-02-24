package server.mapper;

import com.basketball.bo.user.UserLoginVerifyData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from administrator where telephone=#{telephone}")
    UserLoginVerifyData getUserLoginDataByAccount(String telephone);
}
