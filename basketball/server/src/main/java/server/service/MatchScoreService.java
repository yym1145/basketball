package server.service;

import com.basketball.dto.match.score.InsertMatchScoreDTO;
import com.basketball.dto.match.score.PageSelectMatchScoreDTO;
import com.basketball.dto.match.score.SelectMatchScoreDTO;
import com.basketball.result.PageResult;
import com.basketball.vo.match.score.PageSelectMatchScoreVO;
import com.basketball.vo.match.score.SelectMatchScoreVO;

import java.util.List;

public interface MatchScoreService {
    List<SelectMatchScoreVO> selectMatchScore(SelectMatchScoreDTO selectMatchScoreDTO);

    PageResult<PageSelectMatchScoreVO> pageSelectMatchScore(PageSelectMatchScoreDTO pageSelectMatchScoreDTO);

    void insertMatchScore(InsertMatchScoreDTO insertMatchScoreDTO);
}
