package server.service.impl;

import com.basketball.dto.team.SelectTeamsDTO;
import com.basketball.result.PageResult;
import com.basketball.vo.team.SelectTeamsVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.mapper.TeamMapper;
import server.service.TeamService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TeamImpl implements TeamService {
    private final TeamMapper teamMapper;

    @Override
    public PageResult<SelectTeamsVO> selectteams(SelectTeamsDTO selectTeamsDTO) {
        PageHelper.startPage(selectTeamsDTO.getPage(), selectTeamsDTO.getPageSize());
        Page<SelectTeamsVO> page = teamMapper.selectteams(selectTeamsDTO);
        long total = page.getTotal();
        List<SelectTeamsVO> teamList = page.getResult();
        return new PageResult<>(total, teamList);

    }
}
