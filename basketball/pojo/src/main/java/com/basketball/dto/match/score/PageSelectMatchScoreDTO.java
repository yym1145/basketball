package com.basketball.dto.match.score;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author 19625
 */
@Data
public class PageSelectMatchScoreDTO {
    @Schema(description = "事件名称")
    @NotBlank(message = "事件名称为空")
    private String eventName;

    @Schema(description = "事件类型")
    @NotBlank(message = "事件类型为空")
    private String eventType;

    @Schema(description = "页码",defaultValue = "1" ,required = true)
    private Integer page;

    @Schema(description = "每页显示记录数",defaultValue = "10" ,required = true)
    private Integer pageSize;
}
