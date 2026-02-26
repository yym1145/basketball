package server.controller;

import com.basketball.dto.team.AddTeamDTO;
import com.basketball.dto.team.SelectTeamDetailDTO;
import com.basketball.dto.team.SelectTeamsDTO;
import com.basketball.dto.team.UpdateTeamDTO;
import com.basketball.result.PageResult;
import com.basketball.result.Result;
import com.basketball.vo.team.SelectTeamDetailVO;
import com.basketball.vo.team.SelectTeamsVO;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import server.service.TeamService;

@RestController
@RequestMapping("/team")
@CrossOrigin
@Slf4j
@RequiredArgsConstructor
@Tag(name = "球队")
@Validated
public class TeamController {
    private final TeamService teamService;
    @PostMapping("/selectteams")
    @Operation(summary = "查询所有球队")
    @ApiOperationSupport(author = "高梦燚")
    public Result<PageResult<SelectTeamsVO>> selectteams(@RequestBody SelectTeamsDTO selectTeamsDTO){
        return Result.success("查询比赛成功",teamService.selectteams(selectTeamsDTO));
    }
    @PostMapping("/selectteamDetail")
    @Operation(summary = "查询球队详情")
    @ApiOperationSupport(author = "高梦燚")
    public Result<SelectTeamDetailVO> selectteamDetail(@RequestBody SelectTeamDetailDTO selectTeamDetailDTO) throws Exception {
        return Result.success("查询比赛成功",teamService.selectteamDetail(selectTeamDetailDTO));
    }

    @PostMapping("/addTeam")
    @Operation(summary = "新增球队")
    @ApiOperationSupport(author = "高梦燚")
    public Result<Long> addTeam(AddTeamDTO addTeamDTO) throws Exception {
        Long teamId = teamService.addTeam(addTeamDTO);
        return Result.success("新增成功",teamId);
    }

    @PostMapping(value = "/updateTeam")
    @Operation(summary = "修改球队")
    @ApiOperationSupport(author = "高梦燚")
    public Result<String> updateTeam(UpdateTeamDTO updateTeamDTO) throws Exception {
        teamService.updateTeam(updateTeamDTO);
        return Result.success("修改成功",null);
    }

}
