package com.basketball.vo.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CurrentUserDataVO {

    @Schema(description = "用户ID")
    private String id;

    @Schema(description = "用户名称")
    private String name;

}
