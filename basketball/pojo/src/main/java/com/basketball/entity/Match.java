package com.basketball.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class Match {
    @Schema(description = "id")
    private Long id;
    @Schema(description = "比赛id")
    private String matchNumber;
    @Schema(description = "比赛名称")
    private String name;
    @Schema(description = "赛事id")
    private String eventId;
    @Schema(description = "队伍A")
    private String teamA;
    @Schema(description = "队伍B")
    private String teamB;
    @Schema(description = "比赛日期")
    private LocalDate matchDate;
    @Schema(description = "比赛时间")
    private Time startTime;
    @Schema(description = "场馆id")
    private String stadiumId;
    @Schema(description = "状态id")
    private Integer statusId;
}
