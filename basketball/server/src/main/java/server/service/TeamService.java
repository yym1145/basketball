package server.service;


import com.basketball.dto.team.SelectTeamDetailDTO;
import com.basketball.dto.team.SelectTeamsDTO;
import com.basketball.result.PageResult;
import com.basketball.vo.team.SelectTeamDetailVO;
import com.basketball.vo.team.SelectTeamsVO;

public interface TeamService {
    PageResult<SelectTeamsVO> selectteams(SelectTeamsDTO selectTeamsDTO);

    SelectTeamDetailVO selectteamDetail(SelectTeamDetailDTO selectTeamDetailDTO) throws Exception;

    Long addTeam(AddTeamDTO addTeamDTO) throws Exception;

}
