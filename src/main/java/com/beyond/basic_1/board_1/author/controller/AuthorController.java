package com.beyond.basic_1.board_1.author.controller;

import com.beyond.basic_1.board_1.author.authorDto.AuthorCreateDto;
import com.beyond.basic_1.board_1.author.entity.Author;
import com.beyond.basic_1.board_1.author.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {
    public final AuthorService authorService;

    @PostMapping("/create")
    public ResponseEntity<?> save(@RequestBody AuthorCreateDto authorCreateDto) {

        // 예외처리 try-catch 또는 전역 예외 클래스 adviceController

        // Service 넘겨주기
        Author author = authorCreateDto.toEntity();
        authorService.save(author);

        return new ResponseEntity<>("ok", HttpStatus.CREATED);
    }
}
