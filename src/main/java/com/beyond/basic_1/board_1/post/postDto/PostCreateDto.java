package com.beyond.basic_1.board_1.post.postDto;

import com.beyond.basic_1.board_1.author.entity.Author;
import com.beyond.basic_1.board_1.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostCreateDto {
    private String title;
    private String contents;
    private Long authorId;

    // toEntity
    public Post toEntity(Author author) {
        return new Post(this.title, this.contents, author);
    }
}
