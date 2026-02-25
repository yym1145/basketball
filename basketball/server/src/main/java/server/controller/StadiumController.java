package server.controller;

import com.basketball.exception.BaseException;
import com.basketball.exception.stadium.StadiumException;
import com.basketball.result.Result;
import com.basketball.stadium.AddStadiumDTO;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import server.service.StadiumService;

@RestController
@RequestMapping("/stadium")
@CrossOrigin
@Slf4j
@RequiredArgsConstructor
@Tag(name = "场馆")
@Validated
public class StadiumController {
    private final StadiumService stadiumService;
    /**
     * 新增场馆
     * @param addStadiumDTO
     * @return
     */
    @PostMapping("/addStadium")
    @Operation(summary = "新增场馆")
    @ApiOperationSupport(author = "陈嘉豪")
    public Result addStadium(@RequestBody AddStadiumDTO addStadiumDTO){
        if (addStadiumDTO.getStadiumId()!=null){
            stadiumService.addStadium(addStadiumDTO);
            return Result.success("新增成功",addStadiumDTO);
        }else{
            throw new StadiumException("场馆已存在");
        }
    }
}
