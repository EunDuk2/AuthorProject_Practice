package com.beyond.basic_1.board_1.author.controller;

import com.beyond.basic_1.board_1.author.authorDto.AuthorCreateDto;
import com.beyond.basic_1.board_1.author.entity.Author;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {
    // 회원가입
    @PostMapping("/create")
    public ResponseEntity<?> authorCreate(@RequestBody AuthorCreateDto dto) {

        return new ResponseEntity<>("", HttpStatus.CREATED); // ToDo - ResponseCommonDto
    }


}
