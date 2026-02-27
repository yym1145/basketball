package com.basketball.dto.match;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.sql.Time;
import java.time.LocalDate;

@Data
public class MatchDTO {
    @Schema(description = "赛事id")
    private String eventId;
    @Schema(description = "比赛名称")
    private String name;
    @Schema(description = "队伍A")
    private String teamA;
    @Schema(description = "队伍B")
    private String teamB;
    @Schema(description = "比赛日期,格式为yyyy-MM-dd", pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate matchDate;
    @Schema(description = "比赛时间,格式为HH:mm:ss", pattern = "HH:mm:ss")
    @JsonFormat(pattern = "HH:mm:ss")
    private Time startTime;
    @Schema(description = "场馆id")
    private String stadiumId;
    @Schema(description = "状态id")
    private Integer statusId;
}
