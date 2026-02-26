package com.basketball.vo.team;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
public class SelectTeamsVO {
    @Schema(description = "球队ID")
    private Long id;
    @Schema(description = "球队名称")
    private String name;
    @Schema(description = "联系电话")
    private String contactPhone;
    @Schema(description = "球队地址")
    private String address;
    @Schema(description = "球队Logo")
    private String logo;
    @Schema(description = "成立日期")
    private Date establishedDate;
}
