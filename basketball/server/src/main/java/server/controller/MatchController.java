package server.controller;

import com.basketball.dto.match.MatchDTO;
import com.basketball.dto.match.SelectMatchDTO;
import com.basketball.entity.Match;
import com.basketball.result.PageResult;
import com.basketball.result.Result;
import com.basketball.vo.ballMatch.SelectDetailedMatchVO;
import com.basketball.vo.ballMatch.SelectMatchVO;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import server.service.MatchService;



@RestController
@RequestMapping("/match")
@CrossOrigin
@Slf4j
@RequiredArgsConstructor
@Tag(name = "比赛")
@Validated
public class MatchController {

    private final MatchService matchService;

    @PostMapping("/addMatch")
    @Operation(summary = "新增比赛")
    @ApiOperationSupport(author = "卢锐")
    public Result addMatch(@RequestBody MatchDTO matchDTO){
        matchService.addMatch(matchDTO);
        return Result.success("新增比赛成功");
    }

    @PostMapping("/selectMatch")
    @Operation(summary = "查询比赛")
    @ApiOperationSupport(author = "卢锐")
    public Result<PageResult<SelectMatchVO>> selectMatch(@RequestBody SelectMatchDTO selectMatchDTO){
        return Result.success("查询比赛成功",matchService.selectMatch(selectMatchDTO));
    }

    @PostMapping("selectDetailedMatch")
    @Operation(summary = "查询比赛详情")
    @ApiOperationSupport(author = "卢锐")
    public Result<SelectDetailedMatchVO> selectDetailedMatch(@Schema(description = "比赛id") @RequestParam Long matchId){
        return Result.success("查询比赛详情成功",matchService.selectDetailedMatch(matchId));
    }

}
