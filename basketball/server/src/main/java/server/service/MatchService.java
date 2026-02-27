package server.service;

import com.basketball.dto.basketball_match.BasketballMatchDTO;
import com.basketball.dto.basketball_match.SelectBasketballMatchDTO;
import com.basketball.dto.basketball_match.UpdateBasketballMatchDTO;
import com.basketball.result.PageResult;
import com.basketball.vo.ballMatch.SelectDetailedMatchVO;
import com.basketball.vo.ballMatch.SelectMatchVO;

public interface MatchService {
    void addMatch(BasketballMatchDTO match);

    PageResult<SelectMatchVO> selectMatch(SelectBasketballMatchDTO matchDTO);

    SelectDetailedMatchVO selectDetailedMatch(Long matchId);

    void updateMatch(UpdateBasketballMatchDTO updateBasketballMatchDTO);

    void deleteMatch(Long matchId);

    void deleteBatchMatch(Long matchId);
}
