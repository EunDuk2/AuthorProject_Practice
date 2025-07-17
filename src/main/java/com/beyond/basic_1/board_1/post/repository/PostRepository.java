package com.beyond.basic_1.board_1.post.repository;

import com.beyond.basic_1.board_1.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
