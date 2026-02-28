package server.mapper;

import com.basketball.dto.match.score.InsertMatchScoreDTO;
import com.basketball.dto.match.score.PageSelectMatchScoreDTO;
import com.basketball.dto.match.score.SelectMatchScoreDTO;
import com.basketball.entity.MatchScore;
import com.basketball.vo.match.score.PageSelectMatchScoreVO;
import com.basketball.vo.match.score.SelectMatchScoreVO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

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

    List<SelectMatchScoreVO> selectMatchScore(SelectMatchScoreDTO selectMatchScoreDTO);

    Page<PageSelectMatchScoreVO> pageSelectMatchScore(PageSelectMatchScoreDTO pageSelectMatchScoreDTO);

    @Insert("INSERT INTO matchscore (id, match_id, quarter, teama_score, teamb_score) " +
            "VALUES (#{id}, #{matchId}, #{quarter}, #{teamaScore}, #{teambScore})")
    void insertMatchScore(MatchScore matchScore);
}