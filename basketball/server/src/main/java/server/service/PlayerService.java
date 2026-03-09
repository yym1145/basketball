package server.service;

import com.basketball.dto.player.AddPlayerDTO;
import com.basketball.dto.player.UpdatePlayerDTO;
import com.basketball.entity.Player;
import com.basketball.vo.player.SelectPlayerVO;
import org.springframework.web.multipart.MultipartFile;

public interface PlayerService {

    /**
     * 添加球员
     * @param addPlayerDTO
     * @return
     */
    String addPlayer(AddPlayerDTO addPlayerDTO, MultipartFile photo);

     /**
     * 查询球员
     * @param id
     * @return
     */
    SelectPlayerVO selectPlayer(String id);

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
