package server.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.basketball.dto.match.MatchDTO;
import com.basketball.dto.match.SelectMatchDTO;
import com.basketball.entity.Match;
import com.basketball.result.PageResult;
import com.basketball.vo.ballMatch.SelectDetailedMatchVO;
import com.basketball.vo.ballMatch.SelectMatchVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.mapper.MatchMapper;
import server.service.MatchService;

import java.util.List;

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

    @Override
    public PageResult<SelectMatchVO> selectMatch(SelectMatchDTO selectMatchDTO) {
        PageHelper.startPage(selectMatchDTO.getPage(), selectMatchDTO.getPageSize());
        Page<SelectMatchVO> page = matchMapper.selectMatch(selectMatchDTO);
        long total = page.getTotal();
        List<SelectMatchVO> matchList = page.getResult();
        return new PageResult<>(total, matchList);
    }

    @Override
    public SelectDetailedMatchVO selectDetailedMatch(Long matchId) {
        return matchMapper.selectDetailedMatch(matchId);
    }
}
