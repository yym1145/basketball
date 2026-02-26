package server.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.basketball.dto.team.AddTeamDTO;
import com.basketball.dto.team.SelectTeamDetailDTO;
import com.basketball.dto.team.SelectTeamsDTO;
import com.basketball.dto.team.UpdateTeamDTO;
import com.basketball.entity.Team;
import com.basketball.result.PageResult;
import com.basketball.vo.player.PlayerVO;
import com.basketball.vo.team.SelectTeamDetailVO;
import com.basketball.vo.team.SelectTeamsVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import server.mapper.TeamMapper;
import server.service.TeamService;

import java.io.IOException;
import java.time.LocalDate;
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

    @Override
    public SelectTeamDetailVO selectteamDetail(SelectTeamDetailDTO selectTeamDetailDTO) throws Exception {
        SelectTeamDetailVO teamDetail = teamMapper.selectTeamById(selectTeamDetailDTO.getTeamId());
        if (teamDetail == null) {
            throw new Exception("球队不存在");
        }
        List<PlayerVO> players = teamMapper.selectPlayersByTeamId(selectTeamDetailDTO.getTeamId(), selectTeamDetailDTO.getPlayerName());
        teamDetail.setPlayers(players);
        return teamDetail;
    }

    public Long addTeam(AddTeamDTO addTeamDTO) throws Exception {
        if (teamMapper.selectByName(addTeamDTO.getName()) != null) {
            throw new Exception("球队名称已存在");
        }
        Team team = new Team();
        team.setId(IdWorker.getId());
        BeanUtils.copyProperties(addTeamDTO, team);
        MultipartFile logoFile = addTeamDTO.getLogo();
        if (logoFile != null && !logoFile.isEmpty()) {
            try {
                team.setLogo(logoFile.getBytes());
            } catch (IOException e) {

                throw new Exception("Logo上传失败");
            }
        }
        team.setEstablishedDate(LocalDate.parse(addTeamDTO.getEstablishedDate()));
        teamMapper.addTeam(team);
        return team.getId();
    }
}
