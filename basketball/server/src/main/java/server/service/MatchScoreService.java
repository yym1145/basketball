package server.service;

import com.basketball.dto.match.score.*;
import com.basketball.result.PageResult;
import com.basketball.vo.match.score.PageSelectMatchScoreVO;
import com.basketball.vo.match.score.SelectMatchScoreVO;

import java.util.List;

public interface MatchScoreService {
    List<SelectMatchScoreVO> selectMatchScore(SelectMatchScoreDTO selectMatchScoreDTO);

    List<PageSelectMatchScoreVO> pageSelectMatchScore(PageSelectMatchScoreDTO pageSelectMatchScoreDTO);

    void insertMatchScore(InsertMatchScoreDTO insertMatchScoreDTO);

    void updateMatchScore(UpdateMatchScoreDTO updateMatchScoreDTO) throws Exception;

    String deleteMatchScore(DeleteMatchScoreDTO deleteMatchScoreDTO) throws Exception;

    String clearMatchScore(Long eventId) throws Exception;
}
