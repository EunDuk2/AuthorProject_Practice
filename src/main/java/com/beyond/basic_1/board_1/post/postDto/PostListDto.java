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
public class PostListDto {
    private Long id;
    private String title;

    public static PostListDto fromEntity(Post post) {
        return PostListDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .build();
    }
}
