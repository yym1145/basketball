package server.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.basketball.dto.match.MatchDTO;
import com.basketball.dto.match.SelectMatchDTO;
import com.basketball.dto.match.UpdateMatchDTO;
import com.basketball.entity.BasketballMatch;
import com.basketball.exception.BaseException;
import com.basketball.result.PageResult;
import com.basketball.vo.ballMatch.SelectDetailedMatchVO;
import com.basketball.vo.ballMatch.SelectMatchVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import server.mapper.MatchMapper;
import server.service.MatchService;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MatchImpl implements MatchService {

    private final MatchMapper matchMapper;

    @Override
    public void addMatch(MatchDTO matchDTO) {
        BasketballMatch match1=new BasketballMatch();
        match1.setId(IdWorker.getId());
        match1.setMatchNumber(IdWorker.getIdStr());
        match1.setName(matchDTO.getName());
        match1.setMatchDate(matchDTO.getMatchDate());
        match1.setStartTime(matchDTO.getStartTime());
        match1.setEventId(matchDTO.getEventId());
        match1.setTeamA(matchDTO.getTeamA());
        match1.setTeamB(matchDTO.getTeamB());
        match1.setStadiumId(matchDTO.getStadiumId());
        match1.setStatusId(matchDTO.getStatusId());
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

    @Override
    public void updateMatch(UpdateMatchDTO updateMatchDTO) {
        matchMapper.updateMatch(updateMatchDTO);
    }

    @Override
    public void deleteMatch(Long matchId) {
        BasketballMatch basketballMatch=matchMapper.selectById(matchId);
        if(basketballMatch==null){
            throw new BaseException("比赛不存在");
        }
        try {
            matchMapper.deleteById(matchId);
        } catch (DataIntegrityViolationException e) { // MyBatis/Spring抛出的数据完整性异常
            // 判断异常消息中是否包含外键约束的关键字
            if (e.getCause() instanceof SQLIntegrityConstraintViolationException) {
                String message = e.getCause().getMessage();
                if (message.contains("foreign key constraint") && message.contains("matchscore")) {
                    // 抛出自定义业务异常，由全局异常处理器统一返回给前端
                    throw new BaseException("该比赛已有比分记录，无法删除");
                }
            }
            // 其他数据库异常，继续抛出或处理
            throw new RuntimeException("删除失败，请稍后重试", e);
        }
    }

    @Override
    public void deleteBatchMatch(Long matchId) {
        matchMapper.deleteById(matchId);
    }
}
