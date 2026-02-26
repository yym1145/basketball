package com.basketball.vo.player;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
public class PlayerVO {
    @Schema(description = "球员ID")
    private Long id;
    
    @Schema(description = "球员照片")
    private String photo;
    
    @Schema(description = "球员姓名")
    private String name;
    
    @Schema(description = "出生日期")
    private Date dateOfBirth;
    
    @Schema(description = "位置")
    private String position;
    
    @Schema(description = "球衣号码")
    private Long shirtNumber;
}