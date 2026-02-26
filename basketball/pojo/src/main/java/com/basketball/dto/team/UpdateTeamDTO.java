package com.basketball.dto.team;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
public class UpdateTeamDTO {
    @Schema(description = "球队ID", required = true)
    private Long id;
    
    @Schema(description = "球队名称")
    private String name;
    
    @Schema(description = "联系电话")
    private String contactPhone;
    
    @Schema(description = "球队地址")
    private String address;
    
    @Schema(description = "球队Logo")
    private MultipartFile logo;

    private byte[] logoBytes;
}