package com.basketball.dto.match.score;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author 19625
 */
@Data
public class InsertMatchScoreDTO {
    @Schema(description = "比赛数字")
    @NotBlank(message = "比赛数字为空")
    private Long matchNumber;

    @Schema(description = "季度")
    @NotBlank(message = "季度为空")
    private int quarter;

    @Schema(description = "团队A得分")
    @NotBlank(message = "团队A得分为空")
    private int teamAScore;

    @Schema(description = "团队B得分")
    @NotBlank(message = "团队B得分为空")
    private int teamBScore;
}
