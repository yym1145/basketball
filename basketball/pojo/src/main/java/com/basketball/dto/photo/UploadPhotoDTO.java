package com.basketball.dto.photo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UploadPhotoDTO {
    @Schema(description = "比赛id")
    private Long matchId;
    @Schema(description = "照片描述")
    private String description;
}
