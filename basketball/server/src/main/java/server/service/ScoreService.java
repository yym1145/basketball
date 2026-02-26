package server.service;

import com.basketball.dto.match_score.DeleteTeamScoreDTO;
import com.basketball.dto.match_score.ManualAdjustScoreDTO;

public interface ScoreService {
    void manualAdjust(ManualAdjustScoreDTO manualAdjustScoreDTO) throws Exception;
    void deleteTeamScore(DeleteTeamScoreDTO deleteTeamScoreDTO) throws Exception;
    String clearEventScore(Integer eventId) throws Exception;
}