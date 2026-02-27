package com.basketball.dto.player;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
public class AddPlayerDTO {
    @Schema(description = "名")
    private String firstName;

    @Schema(description = "姓")
    private String lastName;

    @Schema(description = "性别")
    private String gender;

    @Schema(description = "出生日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date dateOfBirth;

    @Schema(description = "体重")
    private Integer weight;

    @Schema(description = "身高")
    private Integer height;

    @Schema(description = "球衣号码")
    private Integer shirtNumber;

    @Schema(description = "球员位置")
    private Integer positionId;

    @Schema(description = "球队ID")
    private String teamId;

}
