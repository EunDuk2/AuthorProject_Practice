package com.beyond.basic_1.board_1.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonErrorDto {
    private String errorMessage;
    private int statusCode;
}
