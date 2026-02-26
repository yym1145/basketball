package com.basketball.dto.team;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SelectTeamDetailDTO {
    @Schema(description = "球队ID", required = true)
    private Long teamId;
    @Schema(description = "球员名字模糊搜索")
    private String playerName;
}