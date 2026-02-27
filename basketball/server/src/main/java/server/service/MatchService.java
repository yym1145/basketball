package server.service;

import com.basketball.dto.match.MatchDTO;
import com.basketball.dto.match.SelectMatchDTO;
import com.basketball.dto.match.UpdateMatchDTO;
import com.basketball.result.PageResult;
import com.basketball.vo.ballMatch.SelectDetailedMatchVO;
import com.basketball.vo.ballMatch.SelectMatchVO;

public interface MatchService {
    void addMatch(MatchDTO match);

    PageResult<SelectMatchVO> selectMatch(SelectMatchDTO matchDTO);

    SelectDetailedMatchVO selectDetailedMatch(Long matchId);

    void updateMatch(UpdateMatchDTO updateMatchDTO);

    void deleteMatch(Long matchId);

    void deleteBatchMatch(Long matchId);
}
