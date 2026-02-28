package server.controller;

import com.basketball.dto.match.score.InsertMatchScoreDTO;
import com.basketball.dto.match.score.PageSelectMatchScoreDTO;
import com.basketball.dto.match.score.SelectMatchScoreDTO;
import com.basketball.result.PageResult;
import com.basketball.result.Result;
import com.basketball.vo.match.score.PageSelectMatchScoreVO;
import com.basketball.vo.match.score.SelectMatchScoreVO;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import server.service.MatchScoreService;

import java.util.List;

@RestController
@RequestMapping("/matchScore")
@CrossOrigin
@Slf4j
@RequiredArgsConstructor
@Tag(name = "比赛结果")
@Validated
public class MatchScoreController {
    private final MatchScoreService matchScoreService;

    @PostMapping("/selectMatchScore")
    @Operation(summary = "查询比赛结果")
    @ApiOperationSupport(author = "厉佳铭")
    public Result<List<SelectMatchScoreVO>> selectMatchScore(@RequestBody SelectMatchScoreDTO selectMatchScoreDTO) {
        List<SelectMatchScoreVO> selectMatchScoreVOList = matchScoreService.selectMatchScore(selectMatchScoreDTO);
        return Result.success("查询比赛成功",selectMatchScoreVOList);
    }

    @PostMapping("/pageSelectMatchScore")
    @Operation(summary = "分页查询赛事结果")
    @ApiOperationSupport(author = "厉佳铭")
    public Result<PageResult<PageSelectMatchScoreVO>> selectMatchScore(@RequestBody PageSelectMatchScoreDTO pageSelectMatchScoreDTO) {
        PageResult<PageSelectMatchScoreVO> pageSelectMatchScoreVO = matchScoreService.pageSelectMatchScore(pageSelectMatchScoreDTO);
        return Result.success("查询比赛成功",pageSelectMatchScoreVO);
    }

    @PostMapping("/insertMatchScore")
    @Operation(summary = "比赛结果录入")
    @ApiOperationSupport(author = "厉佳铭")
    public Result insertMatchScore(@RequestBody InsertMatchScoreDTO insertMatchScoreDTO) {
        matchScoreService.insertMatchScore(insertMatchScoreDTO);
        return Result.success("比赛结果录入成功");
    }
}
