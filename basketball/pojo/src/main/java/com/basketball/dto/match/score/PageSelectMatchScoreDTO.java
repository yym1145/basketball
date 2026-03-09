package com.basketball.dto.match.score;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author 19625
 */
@Data
public class PageSelectMatchScoreDTO {
    @Schema(description = "赛事id")
    @NotBlank(message = "赛事id为空")
    private Long eventId;
}
