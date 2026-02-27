package server.service;

import com.basketball.dto.player.AddPlayerDTO;
import com.basketball.dto.player.UpdatePlayerDTO;
import com.basketball.entity.Player;

public interface PlayerService {

    /**
     * 添加球员
     * @param addPlayerDTO
     * @return
     */
    String addPlayer(AddPlayerDTO addPlayerDTO);

     /**
     * 查询球员
     * @param id
     * @return
     */
    Player selectPlayer(String id);

     /**
      * 删除球员
      *
      * @param id
      * @return
      */
    Boolean deletePlayer(String id);

     /**
      * 更新球员信息
      *
      * @param updatePlayerDTO
      * @return
      */
    Boolean updatePlayer(UpdatePlayerDTO updatePlayerDTO);
}
