package server.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.basketball.dto.player.AddPlayerDTO;
import com.basketball.dto.player.UpdatePlayerDTO;
import com.basketball.entity.Player;
import com.basketball.exception.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import server.mapper.PlayerMapper;
import server.service.PlayerService;
@RequiredArgsConstructor
@Service
public class PlayerImpl implements PlayerService {
    private final PlayerMapper playerMapper;
    @Override
    public String addPlayer(AddPlayerDTO addPlayerDTO) {
        if (playerMapper.selectTeamById(addPlayerDTO.getTeamId()) == null) {
            throw new BaseException("选择的球队不存在");
        }
        if (playerMapper.selectPositionById(addPlayerDTO.getPositionId()) == null) {
            throw new BaseException("选择的球员位置不存在");
        }
        Player player = new Player();
        BeanUtils.copyProperties(addPlayerDTO, player);
        player.setId(String.valueOf(IdWorker.getId()));
        playerMapper.insertPlayer(player);
        return player.getId();
    }

    @Override
    public Player selectPlayer(String id) {
        Player player = playerMapper.selectPlayer(id);
        if (player == null) {
            throw new BaseException("球员不存在");
        }
        return player;
    }

    @Override
    public Boolean deletePlayer(String id) {
        Player player = playerMapper.selectPlayer(id);
        if (player == null) {
            throw new BaseException("删除的球员不存在");
        }
        playerMapper.deletePlayer(id);
        return true;
    }

    @Override
    public Boolean updatePlayer(UpdatePlayerDTO dto) {
        Player oldPlayer = playerMapper.selectPlayer(dto.getId());
        if (oldPlayer == null) {
            throw new BaseException("球员不存在");
        }
        Player newPlayer = new Player();
        BeanUtils.copyProperties(dto, newPlayer);
        playerMapper.updatePlayer(newPlayer);
        return true;
    }
}
