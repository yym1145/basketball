package com.basketball.dto.match_score;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class DeleteTeamScoreDTO {
    @Schema(description = "赛事ID", required = true)
    private Integer matchNumber;
    
    @Schema(description = "球队ID", required = true)
    private Long teamId;
}