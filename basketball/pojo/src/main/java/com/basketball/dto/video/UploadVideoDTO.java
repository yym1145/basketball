package com.basketball.dto.video;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class UploadVideoDTO {

    @Schema(description = "简介")
    @NotBlank(message = "简介不能为空")
    private String introduce;

    @Schema(description = "观看人数")
    @NotNull(message = "观看人数不能为空")
    private Long viewCount;

    @Schema(description = "详情")
    @NotBlank(message = "详情不能为空")
    private String particulars;

    @Schema(description = "发布者")
    @NotBlank(message = "发布者不能为空")
    private String publisher;

    @Schema(description = "发布日期")
    @NotNull(message = "发布日期不能为空")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publishDate;
}
