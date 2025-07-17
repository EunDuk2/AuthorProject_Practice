package com.beyond.basic_1.board_1.author.authorDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorChangePasswordDto {
    private Long id;
    private String password;
}
