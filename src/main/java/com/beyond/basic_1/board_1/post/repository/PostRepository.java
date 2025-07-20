package com.beyond.basic_1.board_1.post.repository;

import com.beyond.basic_1.board_1.author.entity.Author;
import com.beyond.basic_1.board_1.post.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Author> findByAuthor(Author author);

    // 게시글 목록 조회 페이징
    Page<Post> findAll(Pageable pageable);
}
