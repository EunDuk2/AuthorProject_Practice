package com.beyond.basic_1.board_1.author.authorDto;

import com.beyond.basic_1.board_1.author.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorListDto {
    private Long id;
    private String name;

    public static AuthorListDto fromEntity(Author author) {
        return AuthorListDto.builder()
                .id(author.getId())
                .name(author.getName())
                .build();
    }
}
