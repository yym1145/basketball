package com.basketball.enums.tournament;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Schema(description = "赛事类型（1.直接淘汰制；2.单循环制）")
public enum TournamentType {
    DIRECT_KNOCKOUT(1, "直接淘汰制"),
    SINGLE_CYCLE(2, "单循环制");

    @JsonValue
    @EnumValue
    private final Integer code;

    private final String desc;
}
