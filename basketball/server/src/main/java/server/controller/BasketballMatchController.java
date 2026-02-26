package server.controller;

import com.basketball.dto.basketball_match.BasketballMatchDTO;

import com.basketball.dto.basketball_match.SelectBasketballMatchDTO;
import com.basketball.dto.basketball_match.UpdateBasketballMatchDTO;
import com.basketball.result.PageResult;
import com.basketball.result.Result;
import com.basketball.vo.ballMatch.SelectDetailedMatchVO;
import com.basketball.vo.ballMatch.SelectMatchVO;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import server.service.MatchService;


@RestController
@RequestMapping("/basketballMatch")
@CrossOrigin
@Slf4j
@RequiredArgsConstructor
@Tag(name = "比赛管理")
@Validated
public class BasketballMatchController {

    private final MatchService matchService;

    @PostMapping("/addBasketballMatch")
    @Operation(summary = "新增比赛")
    @ApiOperationSupport(author = "卢锐")
    public Result addMatch(@RequestBody BasketballMatchDTO matchDTO) {
        matchService.addMatch(matchDTO);
        return Result.success("新增比赛成功");
    }

    @PostMapping("/selectBasketballMatch")
    @Operation(summary = "查询比赛")
    @ApiOperationSupport(author = "卢锐")
    public Result<PageResult<SelectMatchVO>> selectMatch(@RequestBody SelectBasketballMatchDTO selectBasketballMatchDTO) {
        return Result.success("查询比赛成功", matchService.selectMatch(selectBasketballMatchDTO));
    }


    @PostMapping("selectDetailedBasketballMatch")
    @Operation(summary = "查询比赛详情")
    @ApiOperationSupport(author = "卢锐")
    public Result<SelectDetailedMatchVO> selectDetailedMatch(@Schema(description = "比赛id") @RequestParam Long matchId) {
        return Result.success("查询比赛详情成功", matchService.selectDetailedMatch(matchId));
    }

    @PostMapping("/updateBasketballMatch")
    @Operation(summary = "更新比赛")
    @ApiOperationSupport(author = "卢锐")
    public Result updateMatch(@RequestBody UpdateBasketballMatchDTO updateBasketballMatchDTO) {
        matchService.updateMatch(updateBasketballMatchDTO);
        return Result.success("更新比赛成功");
    }

//    @PostMapping("/deleteBasketballMatch")

}