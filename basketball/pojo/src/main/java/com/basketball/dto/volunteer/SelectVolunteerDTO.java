package com.basketball.dto.volunteer;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SelectVolunteerDTO {
    @Schema(description = "姓名")
    private String name;
    @Schema(description = "赛事id")
    private Long eventId;
    @Schema(description = "页码",defaultValue = "1" ,required = true)
    private Integer page;
    @Schema(description = "每页显示记录数",defaultValue = "10" ,required = true)
    private Integer pageSize;

}
