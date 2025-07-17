package com.beyond.basic_1.board_1.author.service;

import com.beyond.basic_1.board_1.author.entity.Author;
import com.beyond.basic_1.board_1.author.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
// @Transactional
@RequiredArgsConstructor
public class AuthorService {
    public final AuthorRepository authorRepository;

    public void save(Author author) {
        // 예외 던지기
        if (authorRepository.findByEmail(author.getEmail()).isPresent()) {
            throw new IllegalArgumentException("중복되는 이메일입니다.");
        }


        authorRepository.save(author);
    }
}
