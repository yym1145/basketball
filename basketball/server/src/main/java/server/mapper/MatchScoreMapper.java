package server.mapper;

import com.basketball.entity.MatchScore;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface MatchScoreMapper {
    
    @Select("SELECT * FROM matchscore WHERE id = #{id} and match_id = #{matchId} AND quarter = #{quarter}")
    MatchScore selectByMatchIdAndQuarter(Long id, Long matchId, Integer quarter);
    
    @Update("UPDATE matchscore SET teama_score = #{teamaScore}, teamb_score = #{teambScore} " +
            "WHERE match_id = #{matchId} AND quarter = #{quarter}")
    int updateScore(Long matchId, Integer quarter, Integer teamaScore, Integer teambScore);
    
    @Delete("DELETE FROM matchscore WHERE match_id = #{matchId}")
    int deleteByMatchId(Long matchId);

    int deleteByMatchIds(List<Long> matchIds);
}