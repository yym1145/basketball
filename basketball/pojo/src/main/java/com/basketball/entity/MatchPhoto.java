package com.basketball.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MatchPhoto {
    @Schema(description = "比赛-照片文件关联id")
    private Long id;
    @Schema(description = "比赛id")
    private Long matchId;
    @Schema(description = "照片文件id")
    private Long fileId;
    @Schema(description = "描述")
    private String description;
}
