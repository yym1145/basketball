package com.basketball.dto.basketball_match;

import lombok.Data;

import java.util.List;

@Data
public class DeleteBatchBasketballMatchDTO {
    private List<Long> idList;
}
