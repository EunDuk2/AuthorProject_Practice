package com.beyond.basic_1.board_1.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonResponseDto {
    private Object result;
    private String statusMessage;
    private int statusCode;
}
