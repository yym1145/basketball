package com.basketball.dto.match.score;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class DeleteMatchScoreDTO {
    @Schema(description = "ID")
    private Long id;
}
