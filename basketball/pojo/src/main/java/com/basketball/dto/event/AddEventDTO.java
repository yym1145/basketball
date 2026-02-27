package com.basketball.dto.event;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
public class AddEventDTO {
    @Schema(description = "赛事名称",required = true)
    private String name;
    @Schema(description = "赛事开始时间",required = true)
    private LocalDate startDate;
    @Schema(description = "赛事结束时间",required = true)
    private LocalDate endDate;
    @Schema(description = "备注信息")
    private String remark;
    @Schema(description = "赛事类型（1、单循环制，2、直接淘汰制）",required = true)
    private Long eventTypeId;
    @Schema(description = "参赛球队id列表",required = true)
    @Size(min = 2, message = "参赛球队数量至少为2支")
    private List<Long> teamIdList;
}
