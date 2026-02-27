package com.basketball.entity;

import lombok.Data;


@Data
public class MatchScore {
    private Long id;
    private Long matchId;
    private Integer quarter;
    private Integer teamaScore;
    private Integer teambScore;
}
