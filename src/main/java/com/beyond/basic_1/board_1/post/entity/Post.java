package com.beyond.basic_1.board_1.post.entity;

import com.beyond.basic_1.board_1.author.entity.Author;
import com.beyond.basic_1.board_1.post.postDto.PostCreateDto;
import com.beyond.basic_1.board_1.post.postDto.PostListDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {
    // Field
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 1000)
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")  // 외래키
    private Author author;

    @CreationTimestamp
    private LocalDateTime createdTime;

    @UpdateTimestamp
    private LocalDateTime updatedTime;

    // Constructor
    public Post(String title, String contents, Author author) {
        this.title = title;
        this.contents = contents;
        this.author = author;
    }

    // fromEntity
    public PostListDto fromEntity() {
        return new PostListDto(this.id, this.title, this.contents, this.author.getName());
    }
}
