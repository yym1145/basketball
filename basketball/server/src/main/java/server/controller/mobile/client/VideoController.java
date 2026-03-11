package server.controller.mobile.client;

import com.basketball.dto.player.AddPlayerDTO;
import com.basketball.dto.video.SelectAllVideoDTO;
import com.basketball.dto.video.UploadVideoDTO;
import com.basketball.result.PageResult;
import com.basketball.result.Result;
import com.basketball.vo.player.SelectPlayerVO;
import com.basketball.vo.video.GetVideoDetailsVO;
import com.basketball.vo.video.SelectAllVideoVO;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import server.service.VideoService;

import javax.validation.Valid;

@RestController
@RequestMapping("/video")
@CrossOrigin
@Slf4j
@RequiredArgsConstructor
@Tag(name = "视频管理")
@Validated
public class VideoController {

    private final VideoService videoService;

    @PostMapping("/uploadVideo")
    @Operation(summary = "上传视频")
    @ApiOperationSupport(author = "燕怡明")
    public Result<String> uploadVideo(@Valid @Parameter(description = "视频信息",required = true) @RequestPart("dto")
                                          UploadVideoDTO uploadVideoDTO,
                                    @Parameter(description = "视频文件") @RequestPart(value = "video",required = false)
                                    MultipartFile videoFile) {
        String videoId = videoService.uploadVideo(uploadVideoDTO,videoFile);
        return Result.success("上传视频成功",videoId);
    }

    @PostMapping("/selectAllVideo")
    @Operation(summary = "查询所有视频")
    @ApiOperationSupport(author = "燕怡明")
    public Result<PageResult<SelectAllVideoVO>> selectAllVideo(@RequestBody SelectAllVideoDTO  dto) {
        PageResult<SelectAllVideoVO> selectAllVideoVO = videoService.selectAllVideo(dto);
        return Result.success("查询所有视频成功",selectAllVideoVO);
    }


    @PostMapping("/getVideoDetails/{id}")
    @Operation(summary = "视频详情")
    @ApiOperationSupport(author = "燕怡明")
    public Result<GetVideoDetailsVO> getVideoDetails(@Schema(description = "视频id") @PathVariable String id) {
        GetVideoDetailsVO video=videoService.getVideoDetails(id);
        return Result.success("查询视频详情成功",video);
    }


}
