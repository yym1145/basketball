package com.basketball.dto.match_score;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ManualAdjustScoreDTO {
    @Schema(description = "ID", required = true)
    private Long id;

    @Schema(description = "比赛ID", required = true)
    private Long matchId;
    
    @Schema(description = "节次", required = true)
    private Integer quarter;
    
    @Schema(description = "A队调整后得分", required = true)
    private Integer teamaScore;
    
    @Schema(description = "B队调整后得分", required = true)
    private Integer teambScore;
}