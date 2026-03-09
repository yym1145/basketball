package com.basketball.dto.player;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class AddPlayerDTO {
    @Schema(description = "名")
    @NotBlank(message = "名不能为空")
    private String firstName;

    @Schema(description = "姓")
    @NotBlank(message = "姓不能为空")
    private String lastName;

    @Schema(description = "性别")
    @NotBlank(message = "性别不能为空")
    private String gender;

    @Schema(description = "出生日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @NotNull(message = "出生日期不能为空")
    private Date dateOfBirth;

    @Schema(description = "体重")
    @NotNull(message = "体重不能为空")
    private Integer weight;

    @Schema(description = "身高")
    @NotNull(message = "身高不能为空")
    private Integer height;

    @Schema(description = "球衣号码")
    @NotNull(message = "球衣号码不能为空")
    private Integer shirtNumber;

    @Schema(description = "球员位置")
    @NotNull(message = "球员位置不能为空")
    private Integer positionId;

    @Schema(description = "球队ID")
    @NotBlank(message = "球队ID不能为空")
    private String teamId;

}
