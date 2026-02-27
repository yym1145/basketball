package com.basketball.dto.event;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateEventDTO {
    @Schema(description = "赛事id",required = true)
    private Long id;
    @Schema(description = "赛事名称")
    private String name;
    @Schema(description = "赛事开始时间")
    private LocalDate startDate;
    @Schema(description = "赛事结束时间")
    private LocalDate endDate;
    @Schema(description = "赛事类型（1、单循环制，2、直接淘汰制）")
    private Long eventTypeId;
    @Schema(description = "赛事状态（1、未开始，2、进行中，3、已结束，4、已取消）")
    private Long statusId;
    @Schema(description = "备注信息")
    private String remark;
}
