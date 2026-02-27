package server.controller;

import com.basketball.dto.basketball_match.BasketballMatchDTO;

import com.basketball.dto.basketball_match.DeleteBatchBasketballMatchDTO;
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

import java.util.ArrayList;
import java.util.List;


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

    @PostMapping("/deleteBasketballMatch")
    @Operation(summary = "删除比赛")
    @ApiOperationSupport(author = "卢锐")
    public Result deleteMatch(@Schema(description = "比赛id") @RequestParam Long matchId) {
        try {
            matchService.deleteMatch(matchId);
            return Result.success("删除比赛成功");
        } catch (Exception e) {
            //打印异常
            return Result.error("删除失败" + e.getMessage());
        }
    }

    @PostMapping("/deleteBatchBasketballMatch")
    @Operation(summary = "批量删除比赛")
    @ApiOperationSupport(author = "卢锐")
    public Result deleteBatchMatch(@RequestBody DeleteBatchBasketballMatchDTO deleteBatchBasketballMatchDTO) {
        List<Long> errorList = new ArrayList<>();
        for (Long matchId : deleteBatchBasketballMatchDTO.getIdList()) {
            try {
                log.info("成功删除ID为{}的比赛", matchId);
                matchService.deleteBatchMatch(matchId);
            } catch (Exception e) {
                log.error("不能删除ID为{}的比赛,原因:{}", matchId, e.toString());
                errorList.add(matchId);
            }
        }
        if (errorList.isEmpty()) {
            return Result.success("全部删除成功", null);
        }
        return Result.success("未能成功删除所有比赛", errorList);
    }

}