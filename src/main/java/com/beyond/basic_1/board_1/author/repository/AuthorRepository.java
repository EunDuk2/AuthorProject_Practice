package com.beyond.basic_1.board_1.author.repository;

import com.beyond.basic_1.board_1.author.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
