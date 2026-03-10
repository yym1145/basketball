package server.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.basketball.annotation.CleanUpFilesOnError;
import com.basketball.annotation.FilePreSignature;
import com.basketball.dto.team.AddTeamDTO;
import com.basketball.dto.team.SelectTeamDetailDTO;
import com.basketball.dto.team.SelectTeamsDTO;
import com.basketball.dto.team.UpdateTeamDTO;
import com.basketball.entity.Team;
import com.basketball.result.PageResult;
import com.basketball.vo.player.PlayerVO;
import com.basketball.vo.player.SelectPlayerVO;
import com.basketball.vo.team.SelectTeamDetailVO;
import com.basketball.vo.team.SelectTeamsVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import server.mapper.FileMapper;
import server.mapper.TeamMapper;
import server.service.FileService;
import server.service.TeamService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TeamImpl implements TeamService {
    private final TeamMapper teamMapper;
    private final FileService fileService;


    @Override
    @FilePreSignature
    public PageResult<SelectTeamsVO> selectteams(SelectTeamsDTO selectTeamsDTO) {
        PageHelper.startPage(selectTeamsDTO.getPage(), selectTeamsDTO.getPageSize());
        Page<SelectTeamsVO> page = teamMapper.selectteams(selectTeamsDTO);
        long total = page.getTotal();
        List<SelectTeamsVO> teamList = page.getResult();
        return new PageResult<>(total, teamList);

    }

    @Override
    @FilePreSignature
    public SelectTeamDetailVO selectteamDetail(SelectTeamDetailDTO selectTeamDetailDTO) throws Exception {
        Long teamId = selectTeamDetailDTO.getTeamId();
        String playerName = selectTeamDetailDTO.getPlayerName();
        SelectTeamDetailVO teamDetail = teamMapper.selectTeamById(teamId);
        if (teamDetail == null) {
            throw new Exception("球队不存在");
        }
        List<PlayerVO> players = teamMapper.selectPlayersByTeamId(teamId, playerName);
        teamDetail.setPlayers(players);
        return teamDetail;
    }

    @Override
    @CleanUpFilesOnError
    public Long addTeam(AddTeamDTO addTeamDTO) throws Exception {
        if (teamMapper.selectByName(addTeamDTO.getName()) != null) {
            throw new Exception("球队名称已存在");
        }
        Team team = new Team();
        if (addTeamDTO.getLogo() != null) {
            team.setLogo(fileService.upload(addTeamDTO.getLogo()));
        }
        team.setEstablishedDate(LocalDate.parse(addTeamDTO.getEstablishedDate()));
        BeanUtils.copyProperties(addTeamDTO, team);
        team.setId(IdWorker.getId());
        teamMapper.addTeam(team);
        return team.getId();
    }
    @Override
    @CleanUpFilesOnError
    public void updateTeam(UpdateTeamDTO updateTeamDTO) throws Exception {
        Team team = teamMapper.selectById(updateTeamDTO.getId());
        if (team == null) {
            throw new Exception("球队不存在");
        }
        if (StringUtils.hasText(updateTeamDTO.getName()) && !updateTeamDTO.getName().equals(team.getName())) {
            Team existTeam = teamMapper.selectByName(updateTeamDTO.getName());
            if (existTeam != null) {
                throw new Exception("球队名称已存在");
            }
        }
        Long logo = null;
        if (updateTeamDTO.getLogo() != null) {
            logo = fileService.upload(updateTeamDTO.getLogo());
            fileService.removeFile(Collections.singletonList(team.getLogo()));
        }
        teamMapper.updateTeam(updateTeamDTO, logo);
    }

    @Override
    public void deleteTeam(Long id) throws Exception {
        Team team = teamMapper.selectById(id);
        if (team == null) {
            throw new Exception("球队不存在");
        }
        teamMapper.deleteById(id);
        fileService.removeFile(Collections.singletonList(team.getLogo()));
    }
}
