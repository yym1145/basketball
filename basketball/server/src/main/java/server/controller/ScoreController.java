package server.controller;

import com.basketball.dto.match_score.DeleteTeamScoreDTO;
import com.basketball.dto.match_score.ManualAdjustScoreDTO;
import com.basketball.dto.score.SelectOneEventScoreDTO;
import com.basketball.result.Result;
import com.basketball.vo.score.SelectEventScoreVO;
import com.basketball.vo.score.SelectOneEventScoreVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import server.service.ScoreService;

import java.util.List;

@RestController
@RequestMapping("/score")
@Tag(name = "积分管理")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PostMapping("/manualAdjust")
    @Operation(summary = "手动调整积分（修改比赛比分）")
    public Result<String> manualAdjust(@RequestBody ManualAdjustScoreDTO manualAdjustScoreDTO) throws Exception {
        scoreService.manualAdjust(manualAdjustScoreDTO);
        return Result.success("调整成功");
    }

    @PostMapping("/deleteTeamScore")
    @Operation(summary = "删除球队积分记录(仅一场比赛)")
    public Result<String> deleteTeamScore(@RequestBody @Validated DeleteTeamScoreDTO deleteTeamScoreDTO) throws Exception {
        scoreService.deleteTeamScore(deleteTeamScoreDTO);
        return Result.success("");
    }

    @PostMapping("/clearEventScore")
    @Operation(summary = "清空赛事所有积分（清空该赛事所有比分）")
    public Result<String> clearEventScore(@Parameter(description = "赛事id") Integer eventId) throws Exception {
        return Result.success(scoreService.clearEventScore(eventId));
    }

    @PostMapping("/selectEventScore")
    @Operation(summary = "获取赛事积分榜")
    @CrossOrigin
    public Result<List<SelectEventScoreVO>> selectEventScore
            (@Parameter(description = "赛事id") Long eventId) throws Exception {
        return Result.success("查询成功",scoreService.selectEventScore(eventId));
    }

    @PostMapping("/selectOneEventScore")
    @Operation(summary = "获取单支球队赛事积分")
    public Result<List<SelectOneEventScoreVO>> selectOneEventScore
            (@RequestBody SelectOneEventScoreDTO selectOneEventScoreDTO) throws Exception {
        return Result.success("查询成功",scoreService.selectOneEventScore(selectOneEventScoreDTO));
    }
}









