package com.beyond.basic_1.board_1.post.postDto;

import com.beyond.basic_1.board_1.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDetailDto {
    private Long id;
    private String title;
    private String contents;
    private String authorName;

    public static PostDetailDto fromEntity(Post post) {
        return PostDetailDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .contents(post.getContents())
                .authorName(post.getAuthor().getName())
                .build();
    }
}
