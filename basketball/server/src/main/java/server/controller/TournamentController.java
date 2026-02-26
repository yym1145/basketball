package server.controller;

import com.basketball.dto.tournament.AddTournamentDTO;
import com.basketball.result.Result;
import com.basketball.vo.tournament.SelectTournamentListVO;
import com.basketball.vo.tournament.SelectTournamentVO;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import server.service.TournamentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Tournament")
@CrossOrigin
@Slf4j
@RequiredArgsConstructor
@Tag(name = "赛事")
@Validated
public class TournamentController {

    private final TournamentService tournamentService;

    @PostMapping("/addTournament")
    @Operation(summary = "添加赛事")
    @ApiOperationSupport(author = "丁泽锋")
    public Result addTournament(@Valid @RequestBody AddTournamentDTO addTournamentDTO) {
        return Result.success("添加成功,id:", tournamentService.addTournament(addTournamentDTO));
    }

    @PostMapping("/selectTournamentList")
    @Operation(summary = "获取赛事列表")
    @ApiOperationSupport(author = "丁泽锋")
    public Result<List<SelectTournamentListVO>> selectTournamentList() {
        return Result.success("查询成功",tournamentService.selectTournamentList());
    }

    @PostMapping("/selectTournamentDetails")
    @Operation(summary = "获取赛事详情")
    @ApiOperationSupport(author = "丁泽锋")
    public Result<SelectTournamentVO> selectTournamentDetails(@Schema(description = "赛事id") @RequestParam Long id) {
        return Result.success("查询成功",tournamentService.selectTournamentDetails(id));
    }
}
