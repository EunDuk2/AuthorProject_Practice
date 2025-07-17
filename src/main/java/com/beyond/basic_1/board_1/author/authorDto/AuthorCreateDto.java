package com.beyond.basic_1.board_1.author.authorDto;

import com.beyond.basic_1.board_1.author.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorCreateDto {
    private String name;
    private String email;
    private String password;

    public Author toEntity() {
        return new Author(this.name, this.email, this.password);
    }
}
