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
    @Schema(description = "赛事名称")
    @NotBlank(message = "赛事名称为空")
    private String eventName;

    @Schema(description = "赛事数字")
    @NotBlank(message = "赛事数字为空")
    private String matchNumber;
}
