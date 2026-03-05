package com.basketball.dto.match.score;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author 19625
 */
@Data
public class UpdateMatchScoreDTO {
    @Schema(description = "ID")
    private Long id;

    @Schema(description = "A队调整后得分")
    private Integer teamaScore;

    @Schema(description = "B队调整后得分")
    private Integer teambScore;
}
