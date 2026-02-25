package com.basketball.stadium;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AddStadiumDTO {
    @Schema(description = "场馆ID",required = true)
    private Long stadiumId;
    @Schema(description = "场馆名字",required = true)
    private String stadiumName;
    @Schema(description = "场馆地址",required = true)
    private String address;
}
