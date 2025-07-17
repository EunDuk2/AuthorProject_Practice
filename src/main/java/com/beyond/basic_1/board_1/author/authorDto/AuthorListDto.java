package com.beyond.basic_1.board_1.author.authorDto;

import com.beyond.basic_1.board_1.author.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorListDto {
    private Long id;
    private String name;

    // fromEntity
    public static AuthorListDto fromEntity(Author author) {
        return new AuthorListDto(author.getId(), author.getName());
    }
}
