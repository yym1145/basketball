package com.basketball.dto.basketball_match;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SelectBasketballMatchDTO {
    @Schema(description = "比赛名称")
    private String name;
    @Schema(description = "比赛状态")
    private String statusId;
    @Schema(description = "页码",defaultValue = "1" ,required = true)
    private Integer page;
    @Schema(description = "每页显示记录数",defaultValue = "10" ,required = true)
    private Integer pageSize;
}
