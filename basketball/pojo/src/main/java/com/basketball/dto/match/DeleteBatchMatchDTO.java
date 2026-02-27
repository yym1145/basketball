package com.basketball.dto.match;

import lombok.Data;

import java.util.List;

@Data
public class DeleteBatchMatchDTO {
    private List<Long> idList;
}
