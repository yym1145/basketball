package server.controller.mobile.client;

import com.basketball.dto.photo.SelectMatchPhotoListDTO;
import com.basketball.dto.photo.UploadPhotoDTO;
import com.basketball.result.PageResult;
import com.basketball.result.Result;
import com.basketball.vo.photo.SelectAllMatchPhotoVO;
import com.basketball.vo.photo.SelectMatchPhotoVO;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import server.service.PhotoService;

import javax.validation.Valid;

@RestController
@RequestMapping("/photo")
@CrossOrigin
@Slf4j
@RequiredArgsConstructor
@Tag(name = "照片")
@Validated
public class PhotoController {
    private final PhotoService photoService;

    @PostMapping("/uploadPhoto")
    @Operation(summary = "上传比赛照片")
    @ApiOperationSupport(author = "丁泽锋")
    public Result uploadPhoto(@Valid @Parameter(description = "照片信息",required = true) @RequestPart("dto") UploadPhotoDTO uploadPhotoDTO,
                              @Parameter(description = "照片文件") @RequestPart(value = "video",required = false) MultipartFile photoFile){
        String photoId = photoService.uploadPhoto(uploadPhotoDTO,photoFile);
        return Result.success("上传成功，id为：",photoId);
    }

    @PostMapping("/selectPhotoList")
    @Operation(summary = "查看比赛照片列表")
    @ApiOperationSupport(author = "丁泽锋")
    public Result<PageResult<SelectAllMatchPhotoVO>> selectMatchPhotoList(@RequestBody SelectMatchPhotoListDTO selectMatchPhotoListDTO){
        return Result.success("查询成功",photoService.selectAllMatchPhoto(selectMatchPhotoListDTO));
    }

    @PostMapping("/selectMatchPhotoDetails")
    @Operation(summary = "查询图片详情")
    @ApiOperationSupport(author = "丁泽锋")
    public Result<SelectMatchPhotoVO> selectMatchPhoto (@Schema(description = "图片id") @RequestParam Long id){
        return Result.success("查询成功",photoService.selectMatchPhoto(id));
    }
}
