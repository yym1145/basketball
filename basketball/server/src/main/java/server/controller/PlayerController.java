package server.controller;

import com.basketball.dto.match.MatchDTO;
import com.basketball.dto.player.AddPlayerDTO;
import com.basketball.dto.player.UpdatePlayerDTO;
import com.basketball.entity.Player;
import com.basketball.result.Result;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import server.service.PlayerService;

@RestController
@RequestMapping("/player")
@CrossOrigin
@Slf4j
@RequiredArgsConstructor
@Tag(name = "球员管理")
@Validated
public class PlayerController {
    private final PlayerService playerService;

    @PostMapping("/addPlayer")
    @Operation(summary = "新增球员")
    @ApiOperationSupport(author = "燕怡明")
    public Result<String> addPlayer(@RequestBody AddPlayerDTO addPlayerDTO) {
        String playerId = playerService.addPlayer(addPlayerDTO);
        return Result.success("新增球员成功",playerId);
    }

    @PostMapping("/selectPlayer/{id}")
    @Operation(summary = "查询球员")
    @ApiOperationSupport(author = "燕怡明")
    public Result<Player> selectPlayer(@Schema(description = "球员id") @PathVariable String id) {
        Player player=playerService.selectPlayer(id);
        return Result.success("查询球员成功",player);
    }

    @PostMapping("/deletePlayer/{id}")
    @Operation(summary = "删除球员")
    @ApiOperationSupport(author = "燕怡明")
    public Result<Boolean> deletePlayer(@Schema(description = "球员id") @PathVariable String id) {
        playerService.deletePlayer(id);
        return Result.success("删除球员成功",null);
    }

    @PostMapping("/updatePlayer")
    @Operation(summary = "更新球员信息")
    @ApiOperationSupport(author = "燕怡明")
    public Result<Boolean> updatePlayer(@RequestBody UpdatePlayerDTO dto) {
         playerService.updatePlayer(dto);
        return Result.success("更新球员信息成功",null);
    }
}
