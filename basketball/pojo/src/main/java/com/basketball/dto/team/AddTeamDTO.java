package com.basketball.dto.team;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Date;


@Data
public class AddTeamDTO {
    @Schema(description = "球队名称", required = true)
    private String name;
    @Schema(description = "联系电话", required = true)
    private String contactPhone;
    @Schema(description = "球队地址", required = true)
    private String address;
    @Schema(description = "球队Logo")
    private MultipartFile logo;
    @Schema(description = "成立日期（格式：yyyy-MM-dd）", required = true)
    private String establishedDate;
}