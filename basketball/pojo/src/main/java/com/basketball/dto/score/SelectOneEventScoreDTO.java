package com.basketball.dto.score;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SelectOneEventScoreDTO {
    @Schema(description = "事件id")
    @NotBlank(message = "事件id为空")
    private Long eventId;

    @Schema(description = "球队id")
    @NotBlank(message = "球队id为空")
    private Long teamId;
}
