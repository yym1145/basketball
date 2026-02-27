package server.mapper;

import com.basketball.dto.basketball_match.SelectBasketballMatchDTO;
import com.basketball.dto.basketball_match.UpdateBasketballMatchDTO;
import com.basketball.entity.BasketballMatch;
import com.basketball.vo.ballMatch.SelectDetailedMatchVO;
import com.basketball.vo.ballMatch.SelectMatchVO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MatchMapper {

    @Insert("insert into basketball_match(id,match_number,name,event_id,teama,teamb,match_date,start_time,stadium_id,status_id) values(#{id},#{matchNumber},#{name},#{eventId},#{teamA},#{teamB},#{matchDate},#{startTime},#{stadiumId},#{statusId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(BasketballMatch match1);

    Page<SelectMatchVO> selectMatch(SelectBasketballMatchDTO selectBasketballMatchDTO);

    SelectDetailedMatchVO selectDetailedMatch(Long matchId);

    void updateMatch(UpdateBasketballMatchDTO updateBasketballMatchDTO);


    @Select("SELECT * FROM basketball_match WHERE match_number = #{matchNumber} " +
            "AND (teama = #{teamId} OR teamb = #{teamId})")
    List<BasketballMatch> selectByEventAndTeam(Integer matchNumber, Long teamId);

    @Select("SELECT * FROM basketball_match WHERE event_id = #{eventId}")
    List<BasketballMatch> selectByEventId(Integer eventId);

    @Update("UPDATE basketball_match SET status_id = #{statusId} WHERE id = #{id}")
    int updateStatus(Long id, Integer statusId);

    int updateStatusByIds(List<Long> ids, Integer statusId);

    @Select("SELECT * FROM basketball_match WHERE id = #{matchId}")
    BasketballMatch selectById(Long matchId);

    @Delete("DELETE FROM basketball_match WHERE id = #{matchId}")
    void deleteById(Long matchId);
}
