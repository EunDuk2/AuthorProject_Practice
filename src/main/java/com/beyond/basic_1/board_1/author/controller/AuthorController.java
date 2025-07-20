package com.beyond.basic_1.board_1.author.controller;

import com.beyond.basic_1.board_1.author.authorDto.AuthorCreateDto;
import com.beyond.basic_1.board_1.author.entity.Author;
import com.beyond.basic_1.board_1.author.service.AuthorService;
import com.beyond.basic_1.board_1.common.CommonErrorDto;
import com.beyond.basic_1.board_1.common.CommonResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    // 회원가입
    @PostMapping("/create")
    public ResponseEntity<?> authorCreate(@Valid @RequestBody AuthorCreateDto dto) {
        authorService.save(dto);
        return new ResponseEntity<>(new CommonResponseDto(dto, "회원가입 성공", HttpStatus.CREATED.value()), HttpStatus.CREATED);
    }

    // 회원목록 조회
    @GetMapping("/list")
    public ResponseEntity<?> getAuthorList() {
        return new ResponseEntity<>(new CommonResponseDto(authorService.findAll(), "회원목록 조회 성공", HttpStatus.OK.value()), HttpStatus.OK);
    }

}
