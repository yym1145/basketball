package server.controller;

import com.basketball.dto.volunteer.UpdateVolunteerDTO;
import com.basketball.dto.volunteer.VolunteerDTO;
import com.basketball.result.Result;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import server.service.VolunteerService;

@RestController
@RequestMapping("/volunteer")
@CrossOrigin
@Slf4j
@RequiredArgsConstructor
@Tag(name = "志愿者")
@Validated
public class VolunteerController {

    private final VolunteerService volunteerService;

    @PostMapping("/addVolunteer")
    @Operation(summary = "添加志愿者")
    @ApiOperationSupport(author = "卢锐")
    public Result addVolunteer(@RequestBody VolunteerDTO volunteerDTO) {
        volunteerService.addVolunteer(volunteerDTO);
        return Result.success("添加志愿者成功");
    }

    @PostMapping("/deleteVolunteer")
    @Operation(summary = "删除志愿者")
    @ApiOperationSupport(author = "卢锐")
    public Result deleteVolunteer(@RequestParam Long id) {
        volunteerService.deleteVolunteer(id);
        return Result.success("删除志愿者成功");
    }

    @PostMapping("/updateVolunteer")
    @Operation(summary = "更新志愿者")
    @ApiOperationSupport(author = "卢锐")
    public Result updateVolunteer(@RequestBody UpdateVolunteerDTO updateVolunteerDTO) {
        volunteerService.updateVolunteer(updateVolunteerDTO);
        return Result.success("更新志愿者成功");
    }

}





