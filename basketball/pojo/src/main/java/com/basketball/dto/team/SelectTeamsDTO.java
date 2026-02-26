package com.basketball.dto.team;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SelectTeamsDTO {
    @Schema(description = "球队名称")
    private String name;
    @Schema(description = "页码",defaultValue = "1" ,required = true)
    private Integer page;
    @Schema(description = "每页显示记录数",defaultValue = "10" ,required = true)
    private Integer pageSize;
}
