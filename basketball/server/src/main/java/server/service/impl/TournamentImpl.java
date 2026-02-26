package server.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.basketball.dto.tournament.AddTournamentDTO;
import com.basketball.entity.Tournament;
import com.basketball.entity.TournamentTeam;
import com.basketball.vo.tournament.SelectTournamentListVO;
import com.basketball.vo.tournament.SelectTournamentVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import server.mapper.TournamentMapper;
import server.service.TournamentService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TournamentImpl implements TournamentService {

    private final TournamentMapper tournamentMapper;
    @Override
    public String addTournament(AddTournamentDTO addTournamentDTO) {
        Tournament tournament = new Tournament();
        BeanUtils.copyProperties(addTournamentDTO, tournament);
        tournament.setId(IdWorker.getId());
        tournamentMapper.addTournament(tournament);
        Long tournamentId = tournament.getId();
        for (Long teamId : addTournamentDTO.getTeamIdList()) {
            TournamentTeam tournamentTeam = new TournamentTeam();
            tournamentTeam.setId(IdWorker.getId());
            tournamentTeam.setTournamentId(tournamentId);
            tournamentTeam.setTeamId(teamId);
            tournamentMapper.addTournamentTeam(tournamentTeam);
        }
        return String.valueOf(tournamentId);
    }

    @Override
    public List<SelectTournamentListVO> selectTournamentList() {
        return tournamentMapper.selectTournamentList();
    }

    @Override
    public SelectTournamentVO selectTournamentDetails(Long id) {
        return tournamentMapper.selectTournamentDetails(id);
    }
}
