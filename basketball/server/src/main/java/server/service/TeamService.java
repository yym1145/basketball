package server.service;


import com.basketball.dto.team.SelectTeamsDTO;
import com.basketball.result.PageResult;
import com.basketball.vo.team.SelectTeamsVO;

public interface TeamService {
    PageResult<SelectTeamsVO> selectteams(SelectTeamsDTO selectTeamsDTO);
}
