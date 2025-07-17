package com.beyond.basic_1.board_1.post.postDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostListDto {
    private Long id;
    private String title;
    private String contents;
    private String authorName;
}
