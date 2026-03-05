package server.controller;

import com.basketball.exception.BaseException;
import com.basketball.exception.stadium.StadiumException;
import com.basketball.result.PageResult;
import com.basketball.result.Result;
import com.basketball.stadium.AddStadiumDTO;
import com.basketball.stadium.StadiumPageQueryDTO;
import com.basketball.stadium.UpdateStadiumDTO;
import com.basketball.vo.Stadium.PageStadiumVO;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
    /**
     * 删除场馆
     *
     * @Param id
     * @Return
     */
    @PostMapping("/deleteStadium/{id}")
    @Operation(summary = "删除场馆")
    @ApiOperationSupport(author = "陈嘉豪")
    public Result deleteStadium(@PathVariable @Parameter(description = "要删除的场馆的id") Long id) {
        Result result = new Result<>();
        try {
            stadiumService.deleteStadium(id);
            return Result.success("删除成功");
        } catch (Exception e) {
            return Result.error("删除失败，可能是id不存在");
        }
    }
    /**
     * 分页查询所有场馆
     * @param stadiumPageQueryDTO
     * @return
     */
    @PostMapping("/PageStadium")
    @Operation(summary = "分页查询所有场馆")
    @ApiOperationSupport(author = "陈嘉豪")
    public Result<PageResult<PageStadiumVO>> pageWarehouse(@RequestBody StadiumPageQueryDTO stadiumPageQueryDTO){
        log.info("开始分页查询所有场馆");
        try{
            PageResult<PageStadiumVO> pageResult= stadiumService.pageStadium(stadiumPageQueryDTO);
            return Result.success("查询成功",pageResult);
        }catch (BaseException e){
            return Result.error(e.getMessage());
        }
    }
    /**
     * 对场馆进行修改
     *
     * @param updateStadiumDTO
     * @return
     */
    @PostMapping("/updateStadium")
    @Operation(summary = "对场馆进行修改")
    @ApiOperationSupport(author = "陈嘉豪")
    public Result updateStadium(@RequestBody UpdateStadiumDTO updateStadiumDTO) {
        stadiumService.updateStadium(updateStadiumDTO);
        return Result.success("修改成功", updateStadiumDTO);
    }
}
