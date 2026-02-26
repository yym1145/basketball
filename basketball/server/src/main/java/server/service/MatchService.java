package server.service;

import com.basketball.dto.match.MatchDTO;
import com.basketball.dto.match.SelectMatchDTO;
import com.basketball.entity.Match;
import com.basketball.result.PageResult;
import com.basketball.vo.ballMatch.SelectDetailedMatchVO;
import com.basketball.vo.ballMatch.SelectMatchVO;

public interface MatchService {
    void addMatch(MatchDTO match);

    PageResult<SelectMatchVO> selectMatch(SelectMatchDTO matchDTO);

    SelectDetailedMatchVO selectDetailedMatch(Long matchId);
}
