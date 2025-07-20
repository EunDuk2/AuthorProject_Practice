package com.beyond.basic_1.board_1.author.authorDto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorCreateDto {
    @NotEmpty(message = "이름이 비어있습니다.") // ToDo - 예외처리
    private String name;
    @NotEmpty(message = "이메일이 비어있습니다.")
    private String email;
    @NotEmpty(message = "비밀번호가 비어있습니다.")
    @Size(min = 8, message = "비밀번호가 너무 짧습니다.") // ToDo - 예외처리
    private String password;
}
