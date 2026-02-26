package com.basketball.vo.tournament;

import com.basketball.enums.tournament.TournamentType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SelectTournamentListVO {
    @Schema(description = "赛事id")
    private Long id;
    @Schema(description = "赛事名称")
    private String name;
    @Schema(description = "赛事类型")
    private TournamentType tournamentType;
    @Schema(description = "开始时间")
    private LocalDateTime startTime;
    @Schema(description = "结束时间")
    private LocalDateTime endTime;
}
