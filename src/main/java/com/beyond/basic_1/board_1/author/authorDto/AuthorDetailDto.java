package com.beyond.basic_1.board_1.author.authorDto;

import com.beyond.basic_1.board_1.author.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDetailDto {
    private Long id;
    private String name;
    private String email;

    // fromEntity
    public static AuthorDetailDto fromEntity(Author author) {
        return new AuthorDetailDto(author.getId(), author.getName(), author.getEmail());
    }
}
