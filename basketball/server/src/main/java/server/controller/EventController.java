package server.controller;

import com.basketball.result.Result;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import server.service.EventService;

@RestController
@RequestMapping("/event")
@CrossOrigin
@Slf4j
@RequiredArgsConstructor
@Tag(name = "赛事")
@Validated
public class EventController {
    private final EventService eventService;
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
