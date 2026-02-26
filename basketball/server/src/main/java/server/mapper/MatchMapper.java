package server.mapper;

import com.basketball.dto.match.SelectMatchDTO;
import com.basketball.entity.Match;
import com.basketball.vo.ballMatch.SelectMatchVO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface MatchMapper {

    @Insert("insert into basketball_match(id,match_number,name,event_id,teama,teamb,match_date,start_time,stadium_id,status_id) values(#{id},#{matchNumber},#{name},#{eventId},#{teamA},#{teamB},#{matchDate},#{startTime},#{stadiumId},#{statusId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Match match1);

    Page<SelectMatchVO> selectMatch(SelectMatchDTO selectMatchDTO);
}
