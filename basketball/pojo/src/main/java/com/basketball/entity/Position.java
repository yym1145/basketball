package com.basketball.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class Position {
    @Schema(description = "球员职位id")
    private String id;

    @Schema(description = "球员职位名称")
    private String name;
}
