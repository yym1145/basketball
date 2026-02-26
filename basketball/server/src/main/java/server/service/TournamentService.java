package server.service;

import com.basketball.dto.tournament.AddTournamentDTO;
import com.basketball.vo.tournament.SelectTournamentListVO;
import com.basketball.vo.tournament.SelectTournamentVO;

import java.util.List;

public interface TournamentService {
    String addTournament(AddTournamentDTO addTournamentDTO);

    List<SelectTournamentListVO> selectTournamentList();

    SelectTournamentVO selectTournamentDetails(Long id);
}
