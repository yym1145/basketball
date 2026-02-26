package server.mapper;

import com.basketball.dto.team.SelectTeamsDTO;
import com.basketball.vo.player.PlayerVO;
import com.basketball.vo.team.SelectTeamDetailVO;
import com.basketball.vo.team.SelectTeamsVO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeamMapper {

    /**
     * 查询所有球队
     */
    Page<SelectTeamsVO> selectteams(SelectTeamsDTO selectTeamsDTO);

    /**
     * 查询球队基本信息
     */
    SelectTeamDetailVO selectTeamById(Long teamId);

    /**
     * 查询球队球员列表
     */
    List<PlayerVO> selectPlayersByTeamId( Long teamId, String playerName);
}
