package com.basketball.dto.event;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

@Data
public class UpdateEventTeamDTO {
    @Schema(description = "赛事id",required = true)
    private Long id;
    @Schema(description = "参赛队伍id列表")
    @Size(min = 2, message = "参赛球队数量至少为2支")
    private List<Long> teamIdList;
}
