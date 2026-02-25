package server.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.basketball.dto.match.MatchDTO;
import com.basketball.entity.Match;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.mapper.MatchMapper;
import server.service.MatchService;
import org.springframework.beans.BeanUtils;

import java.sql.Time;

@RequiredArgsConstructor
@Service
public class MatchImpl implements MatchService {

    private final MatchMapper matchMapper;

    @Override
    public void addMatch(MatchDTO match) {
        Match match1=new Match();
        match1.setId(IdWorker.getId());
        match1.setMatchNumber(IdWorker.getIdStr());
        match1.setName(match.getName());
        match1.setMatchDate(match.getMatchDate());
        match1.setStartTime(match.getStartTime());
        match1.setEventId(match.getEventId());
        match1.setTeamA(match.getTeamA());
        match1.setTeamB(match.getTeamB());
        match1.setStadiumId(match.getStadiumId());
        match1.setStatusId(match.getStatusId());
        matchMapper.insert(match1);
    }
}
