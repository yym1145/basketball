package server.service.impl;

//import com.basketball.dto.match_score.DeleteTeamScoreDTO;
import com.basketball.dto.match_score.DeleteTeamScoreDTO;
import com.basketball.dto.match_score.ManualAdjustScoreDTO;
import com.basketball.entity.BasketballMatch;
import com.basketball.entity.MatchScore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.mapper.MatchMapper;
import server.mapper.MatchScoreMapper;
import server.service.ScoreService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private MatchScoreMapper matchScoreMapper;
    @Autowired
    private MatchMapper matchMapper;


    @Override
    public void manualAdjust(ManualAdjustScoreDTO manualAdjustScoreDTO) throws Exception {
        MatchScore existScore = matchScoreMapper.selectByMatchIdAndQuarter(manualAdjustScoreDTO.getId(), manualAdjustScoreDTO.getMatchId(), manualAdjustScoreDTO.getQuarter());
        if (existScore == null) {
            throw new Exception("该节比分记录不存在");
        }
        matchScoreMapper.updateScore(manualAdjustScoreDTO.getMatchId(), manualAdjustScoreDTO.getQuarter(), manualAdjustScoreDTO.getTeamaScore(), manualAdjustScoreDTO.getTeambScore());

    }

    @Override
    public void deleteTeamScore(DeleteTeamScoreDTO deleteTeamScoreDTO) throws Exception {
        List<BasketballMatch> matches = matchMapper.selectByEventAndTeam(deleteTeamScoreDTO.getMatchNumber(), deleteTeamScoreDTO.getTeamId());

        if (matches.isEmpty()) {
            throw new Exception("该球队在此赛事无比赛记录");
        }
        for (BasketballMatch match : matches) {
            matchScoreMapper.deleteByMatchId(match.getId());
        }

        for (BasketballMatch match : matches) {
            matchMapper.updateStatus(match.getId(), 4);
        }
    }

    @Override
    public String clearEventScore(Integer eventId) throws Exception {

        List<BasketballMatch> matches = matchMapper.selectByEventId(eventId);

        if (matches.isEmpty()) {
            throw new Exception("该赛事无比赛记录");
        }
        List<Long> matchIds = matches.stream()
                .map(BasketballMatch::getId)
                .collect(Collectors.toList());

        int deleted = matchScoreMapper.deleteByMatchIds(matchIds);
        matchMapper.updateStatusByIds(matchIds, 1);
        return "清空赛事积分完成：赛事"+eventId+"涉及比赛"+matches.size()+"场，删除比分"+deleted+"条";
    }
}