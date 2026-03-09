package com.basketball.dto.match.score;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author 19625
 */
@Data
public class SelectMatchScoreDTO {
    @Schema(description = "比赛id")
    @NotBlank(message = "比赛id为空")
    private Long matchId;
}
