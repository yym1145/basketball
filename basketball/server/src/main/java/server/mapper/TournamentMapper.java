package server.mapper;

import com.basketball.dto.tournament.UpdateTournamentDTO;
import com.basketball.dto.tournament.UpdateTournamentTeamDTO;
import com.basketball.entity.Tournament;
import com.basketball.entity.TournamentTeam;
import com.basketball.vo.tournament.SelectTournamentListVO;
import com.basketball.vo.tournament.SelectTournamentVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TournamentMapper {

    @Insert("insert into tournament(id, name, tournament_type, start_time, end_time, remark) " +
            "values(#{id}, #{name}, #{tournamentType}, #{startTime}, #{endTime}, #{remark})")
        void addTournament(Tournament tournament);

    @Insert("insert into tournament_team(id, tournament_id, team_id) " +
            "values(#{id}, #{tournamentId}, #{teamId})")
    void addTournamentTeam(TournamentTeam tournamentTeam);

    @Select("select id, name, tournament_type, start_time, end_time from tournament")
    List<SelectTournamentListVO> selectTournamentList();

    SelectTournamentVO selectTournamentDetails(Long id);
}
