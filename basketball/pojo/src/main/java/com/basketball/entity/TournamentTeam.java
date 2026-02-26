package com.basketball.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class TournamentTeam {
    @Schema(description = "赛事-球队关联id")
    private Long id;
    @Schema(description = "赛事id")
    private Long tournamentId;
    @Schema(description = "队伍id")
    private Long teamId;
}
