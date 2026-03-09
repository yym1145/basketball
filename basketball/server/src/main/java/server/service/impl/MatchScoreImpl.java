package server.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.basketball.dto.match.score.*;
import com.basketball.entity.Event;
import com.basketball.entity.MatchScore;
import com.basketball.result.PageResult;
import com.basketball.vo.match.score.PageSelectMatchScoreVO;
import com.basketball.vo.match.score.SelectMatchScoreVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import server.mapper.EventMapper;
import server.mapper.MatchMapper;
import server.mapper.MatchScoreMapper;
import server.service.MatchScoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchScoreImpl implements MatchScoreService {

    private final EventMapper eventMapper;

    private final MatchMapper matchMapper;

    private final MatchScoreMapper matchScoreMapper;

    @Override
    public List<SelectMatchScoreVO> selectMatchScore(SelectMatchScoreDTO selectMatchScoreDTO) {
        return matchScoreMapper.selectMatchScore(selectMatchScoreDTO);
    }

    @Override
    public List<PageSelectMatchScoreVO> pageSelectMatchScore(PageSelectMatchScoreDTO pageSelectMatchScoreDTO) {
        return matchScoreMapper.pageSelectMatchScore(pageSelectMatchScoreDTO);
    }

    @Override
    public void insertMatchScore(InsertMatchScoreDTO insertMatchScoreDTO) {
        MatchScore matchScore = new MatchScore();
        Long matchId=matchMapper.selectMatchId(insertMatchScoreDTO.getMatchNumber());
        matchScore.setId(IdWorker.getId());
        matchScore.setMatchId(matchId);
        matchScore.setQuarter(insertMatchScoreDTO.getQuarter());
        matchScore.setTeamaScore(insertMatchScoreDTO.getTeamAScore());
        matchScore.setTeambScore(insertMatchScoreDTO.getTeamBScore());
        matchScoreMapper.insertMatchScore(matchScore);
    }


    @Override
    public void updateMatchScore(UpdateMatchScoreDTO updateMatchScoreDTO) throws Exception {
        MatchScore matchScoreId = matchScoreMapper.selectByMatchScoreId(updateMatchScoreDTO.getId());
        if (matchScoreId == null) {
            throw new Exception("该比赛结果不存在");
        }
        MatchScore matchScore = new MatchScore();
        matchScore.setId(updateMatchScoreDTO.getId());
        matchScore.setTeamaScore(updateMatchScoreDTO.getTeamaScore());
        matchScore.setTeambScore(updateMatchScoreDTO.getTeambScore());
        matchScoreMapper.updateMatchScore(matchScore);
    }

    @Override
    public String deleteMatchScore(DeleteMatchScoreDTO deleteMatchScoreDTO) throws Exception {
        MatchScore matchScoreId = matchScoreMapper.selectByMatchScoreId(deleteMatchScoreDTO.getId());
        if (matchScoreId == null) {
            throw new Exception("该比赛结果不存在");
        }
        matchScoreMapper.deleteByMatchScoreId(matchScoreId.getId());
        return "删除成功";
    }

    @Override
    public String clearMatchScore(Long eventId) throws Exception {
        Event event = eventMapper.selectById(eventId);
        if (event == null) {
            throw new Exception("无该赛事");
        }
        List<Long> matchIds = matchMapper.selectByEventId(eventId);
        matchScoreMapper.deleteByMatchIds(matchIds);
        return "清空赛事完成";
    }
}
