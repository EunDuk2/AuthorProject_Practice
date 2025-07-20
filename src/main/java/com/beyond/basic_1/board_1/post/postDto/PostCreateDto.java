package com.beyond.basic_1.board_1.post.postDto;

import com.beyond.basic_1.board_1.author.entity.Author;
import com.beyond.basic_1.board_1.post.entity.Post;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostCreateDto {
    @NotEmpty(message = "제목이 비어있습니다.")
    private String title;
    @NotEmpty(message = "내용이 비어있습니다.")
    private String contents;
    @NotNull(message = "회원 ID가 없습니다.")
    private Long authorId;

    public Post toEntity(Author author) {
        return Post.builder()
                .title(this.title)
                .contents(this.contents)
                .author(author)
                .build();
    }
}
