package server.service;

//import com.basketball.dto.match_score.DeleteTeamScoreDTO;
import com.basketball.dto.match_score.DeleteTeamScoreDTO;
import com.basketball.dto.match_score.ManualAdjustScoreDTO;
import com.basketball.dto.score.SelectOneEventScoreDTO;
import com.basketball.vo.score.SelectEventScoreVO;
import com.basketball.vo.score.SelectOneEventScoreVO;

import java.util.List;

public interface ScoreService {
    void manualAdjust(ManualAdjustScoreDTO manualAdjustScoreDTO) throws Exception;
    void deleteTeamScore(DeleteTeamScoreDTO deleteTeamScoreDTO) throws Exception;
    String clearEventScore(Integer eventId) throws Exception;

    List<SelectEventScoreVO> selectEventScore(Long eventId) throws Exception;

    List<SelectOneEventScoreVO> selectOneEventScore(SelectOneEventScoreDTO selectOneEventScoreDTO) throws Exception;
}