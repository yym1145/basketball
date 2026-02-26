package server.service;

import com.basketball.dto.tournament.AddTournamentDTO;
import com.basketball.dto.tournament.UpdateTournamentDTO;
import com.basketball.dto.tournament.UpdateTournamentTeamDTO;
import com.basketball.result.Result;
import com.basketball.vo.tournament.SelectTournamentListVO;
import com.basketball.vo.tournament.SelectTournamentVO;

import java.util.List;

public interface TournamentService {
    String addTournament(AddTournamentDTO addTournamentDTO);

    List<SelectTournamentListVO> selectTournamentList();

    SelectTournamentVO selectTournamentDetails(Long id);

    Result<String> updateTournament(UpdateTournamentDTO updateTournamentDTO);

    Object updateTournamentTeam(UpdateTournamentTeamDTO updateTournamentTeamDTO);
}
