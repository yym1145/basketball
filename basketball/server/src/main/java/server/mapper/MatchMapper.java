package server.mapper;

import com.basketball.dto.basketball_match.SelectBasketballMatchDTO;
import com.basketball.dto.basketball_match.UpdateBasketballMatchDTO;
import com.basketball.entity.BasketballMatch;
import com.basketball.vo.ballMatch.SelectDetailedMatchVO;
import com.basketball.vo.ballMatch.SelectMatchVO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface MatchMapper {

    @Insert("insert into basketball_match(id,match_number,name,event_id,teama,teamb,match_date,start_time,stadium_id,status_id) values(#{id},#{matchNumber},#{name},#{eventId},#{teamA},#{teamB},#{matchDate},#{startTime},#{stadiumId},#{statusId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(BasketballMatch match1);

    Page<SelectMatchVO> selectMatch(SelectBasketballMatchDTO selectBasketballMatchDTO);

    SelectDetailedMatchVO selectDetailedMatch(Long matchId);

    void updateMatch(UpdateBasketballMatchDTO updateBasketballMatchDTO);
}
