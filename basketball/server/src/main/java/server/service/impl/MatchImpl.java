package server.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.basketball.dto.basketball_match.BasketballMatchDTO;
import com.basketball.dto.basketball_match.SelectBasketballMatchDTO;
import com.basketball.dto.basketball_match.UpdateBasketballMatchDTO;
import com.basketball.entity.BasketballMatch;
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
    public void addMatch(BasketballMatchDTO basketballMatchDTO) {
        BasketballMatch match1=new BasketballMatch();
        match1.setId(IdWorker.getId());
        match1.setMatchNumber(IdWorker.getIdStr());
        match1.setName(basketballMatchDTO.getName());
        match1.setMatchDate(basketballMatchDTO.getMatchDate());
        match1.setStartTime(basketballMatchDTO.getStartTime());
        match1.setEventId(basketballMatchDTO.getEventId());
        match1.setTeamA(basketballMatchDTO.getTeamA());
        match1.setTeamB(basketballMatchDTO.getTeamB());
        match1.setStadiumId(basketballMatchDTO.getStadiumId());
        match1.setStatusId(basketballMatchDTO.getStatusId());
        matchMapper.insert(match1);
    }

    @Override
    public PageResult<SelectMatchVO> selectMatch(SelectBasketballMatchDTO selectBasketballMatchDTO) {
        PageHelper.startPage(selectBasketballMatchDTO.getPage(), selectBasketballMatchDTO.getPageSize());
        Page<SelectMatchVO> page = matchMapper.selectMatch(selectBasketballMatchDTO);
        long total = page.getTotal();
        List<SelectMatchVO> matchList = page.getResult();
        return new PageResult<>(total, matchList);
    }

    @Override
    public SelectDetailedMatchVO selectDetailedMatch(Long matchId) {
        return matchMapper.selectDetailedMatch(matchId);
    }

    @Override
    public void updateMatch(UpdateBasketballMatchDTO updateBasketballMatchDTO) {
        matchMapper.updateMatch(updateBasketballMatchDTO);
    }
}
