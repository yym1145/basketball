package server.controller;

import com.basketball.dto.match_score.ManualAdjustScoreDTO;
import com.basketball.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.service.ScoreService;

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

//    @PostMapping("/deleteTeamScore")
//    @Operation(summary = "删除球队积分记录(仅一场比赛)")
//    public Result<String> deleteTeamScore(@RequestBody @Validated DeleteTeamScoreDTO deleteTeamScoreDTO) throws Exception {
//        scoreService.deleteTeamScore(deleteTeamScoreDTO);
//        return Result.success("");
//    }

    @PostMapping("/clearEventScore")
    @Operation(summary = "清空赛事所有积分（清空该赛事所有比分）")
    public Result<String> clearEventScore(@Parameter(description = "赛事id") Integer eventId) throws Exception {
        return Result.success(scoreService.clearEventScore(eventId));
    }
}