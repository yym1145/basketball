package server.mapper;

import com.basketball.dto.match.SelectMatchDTO;
import com.basketball.dto.match.UpdateMatchDTO;
import com.basketball.entity.BasketballMatch;
import com.basketball.vo.ballMatch.SelectDetailedMatchVO;
import com.basketball.vo.ballMatch.SelectMatchVO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MatchMapper {

    @Insert("insert into `match`(id,match_number,name,event_id,teama,teamb,match_date,start_time,stadium_id,status_id) values(#{id},#{matchNumber},#{name},#{eventId},#{teamA},#{teamB},#{matchDate},#{startTime},#{stadiumId},#{statusId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(BasketballMatch match1);

    Page<SelectMatchVO> selectMatch(SelectMatchDTO selectMatchDTO);

    SelectDetailedMatchVO selectDetailedMatch(Long matchId);

    void updateMatch(UpdateMatchDTO updateMatchDTO);


    @Select("SELECT * FROM `match` WHERE match_number = #{matchNumber} " +
            "AND (teama = #{teamId} OR teamb = #{teamId})")
    List<BasketballMatch> selectByEventAndTeam(Integer matchNumber, Long teamId);

    @Select("SELECT * FROM `match` WHERE event_id = #{eventId}")
    List<BasketballMatch> selectByEventId(Integer eventId);

    @Update("UPDATE `match` SET status_id = #{statusId} WHERE id = #{id}")
    int updateStatus(Long id, Integer statusId);

    int updateStatusByIds(List<Long> ids, Integer statusId);

    @Select("SELECT * FROM `match` WHERE id = #{matchId}")
    BasketballMatch selectById(Long matchId);

    @Delete("DELETE FROM `match` WHERE id = #{matchId}")
    void deleteById(Long matchId);

    @Select("SELECT id FROM `match` WHERE match_number = #{matchNumber}")
    Long selectMatchId(Long matchNumber);
}
