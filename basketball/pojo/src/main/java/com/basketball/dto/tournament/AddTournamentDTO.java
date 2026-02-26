package com.basketball.dto.tournament;

import com.basketball.enums.tournament.TournamentType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class AddTournamentDTO {
    @Schema(description = "赛事名称",required = true)
    private String name;
    @Schema(description = "赛事类型",required = true)
    private TournamentType type;
    @Schema(description = "赛事开始时间",required = true)
    private LocalDateTime startTime;
    @Schema(description = "赛事结束时间",required = true)
    private LocalDateTime endTime;
    @Schema(description = "备注信息")
    private String remark;
    @Schema(description = "参赛球队id列表",required = true)
    @Size(min = 2, message = "参赛球队数量至少为2支")
    private List<Long> teamIdList;
}
