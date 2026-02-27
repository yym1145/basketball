package server.controller;

import com.basketball.dto.event.AddEventDTO;
import com.basketball.dto.event.UpdateEventDTO;
import com.basketball.dto.event.UpdateEventTeamDTO;
import com.basketball.result.Result;
import com.basketball.vo.event.SelectEventListVO;
import com.basketball.vo.event.SelectEventVO;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import server.service.EventService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/event")
@CrossOrigin
@Slf4j
@RequiredArgsConstructor
@Tag(name = "赛事")
@Validated
public class EventController {

    private final EventService eventService;

    @PostMapping("/addEvent")
    @Operation(summary = "添加赛事")
    @ApiOperationSupport(author = "丁泽锋")
    public Result addEvent(@Valid @RequestBody AddEventDTO addEventDTO) {
        return Result.success("添加成功,id:", eventService.addEvent(addEventDTO));
    }

    @PostMapping("/selectEventList")
    @Operation(summary = "获取赛事列表")
    @ApiOperationSupport(author = "丁泽锋")
    public Result<List<SelectEventListVO>> selectEventList() {
        return Result.success("查询成功",eventService.selectEventList());
    }

    @PostMapping("/selectEventDetails")
    @Operation(summary = "获取赛事详情")
    @ApiOperationSupport(author = "丁泽锋")
    public Result<SelectEventVO> selectEventDetails(@Schema(description = "赛事id") @RequestParam Long id) {
        return Result.success("查询成功",eventService.selectEventDetails(id));
    }

    @PostMapping("/updateEvent")
    @Operation(summary = "修改赛事基本信息")
    @ApiOperationSupport(author = "丁泽锋")
    public Result updateEvent(@Valid @RequestBody UpdateEventDTO updateEventDTO) {
        return Result.success(eventService.updateEvent(updateEventDTO));
    }

    @PostMapping("/updateEventTeam")
    @Operation(summary = "修改赛事参赛队伍")
    @ApiOperationSupport(author = "丁泽锋")
    public Result updateEventTeam(@Valid @RequestBody UpdateEventTeamDTO updateEventTeamDTO) {
        return Result.success(eventService.updateEventTeam(updateEventTeamDTO));
    }
    /**
     * 删除赛事
     * @param id
     * @return
     */
    @PostMapping({"/deleteEvent/{id}"})
    @Operation(summary = "删除赛事")
    @ApiOperationSupport(author = "陈嘉豪")
    public Result deleteStadium(@PathVariable @Parameter(description = "要删除的赛事的id") Long id) {
        try {
            eventService.deleteEvent(id);
            return Result.success("删除成功");
        } catch (Exception e) {
            return Result.error("删除失败，可能是id不存在");
        }
    }
}
