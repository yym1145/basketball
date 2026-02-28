package server.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.basketball.dto.match.score.InsertMatchScoreDTO;
import com.basketball.dto.match.score.PageSelectMatchScoreDTO;
import com.basketball.dto.match.score.SelectMatchScoreDTO;
import com.basketball.entity.MatchScore;
import com.basketball.result.PageResult;
import com.basketball.vo.match.score.PageSelectMatchScoreVO;
import com.basketball.vo.match.score.SelectMatchScoreVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import server.mapper.MatchMapper;
import server.mapper.MatchScoreMapper;
import server.service.MatchScoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchScoreImpl implements MatchScoreService {

    private final MatchMapper matchMapper;

    private final MatchScoreMapper matchScoreMapper;

    @Override
    public List<SelectMatchScoreVO> selectMatchScore(SelectMatchScoreDTO selectMatchScoreDTO) {
        return matchScoreMapper.selectMatchScore(selectMatchScoreDTO);
    }

    @Override
    public PageResult<PageSelectMatchScoreVO> pageSelectMatchScore(PageSelectMatchScoreDTO pageSelectMatchScoreDTO) {
        PageHelper.startPage(pageSelectMatchScoreDTO.getPage(), pageSelectMatchScoreDTO.getPageSize());
        Page<PageSelectMatchScoreVO> page = matchScoreMapper.pageSelectMatchScore(pageSelectMatchScoreDTO);
        long total = page.getTotal();
        List<PageSelectMatchScoreVO> matchList = page.getResult();
        return new PageResult<>(total, matchList);
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
}
