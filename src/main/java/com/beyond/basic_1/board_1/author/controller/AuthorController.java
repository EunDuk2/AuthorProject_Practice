package com.beyond.basic_1.board_1.author.controller;

import com.beyond.basic_1.board_1.author.authorDto.AuthorCreateDto;
import com.beyond.basic_1.board_1.author.entity.Author;
import com.beyond.basic_1.board_1.author.service.AuthorService;
import com.beyond.basic_1.board_1.common.CommonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {
    public final AuthorService authorService;

    // 회원가입
    @PostMapping("/create")
    public ResponseEntity<?> save(@RequestBody AuthorCreateDto authorCreateDto) {
        // 예외처리 try-catch 또는 전역 예외 클래스 adviceController

        // Service 넘겨주기
        authorService.save(authorCreateDto);

        return new ResponseEntity<>("ok", HttpStatus.CREATED);
    }

    // 회원목록 조회
    @GetMapping("/list")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(new CommonDto(authorService.findAll(), HttpStatus.OK.value(),
                "회원목록 조회 성공"), HttpStatus.OK);
    }

    // 회원 상세조회
    @GetMapping("/detail/{inputId}")
    public ResponseEntity<?> findById(@PathVariable Long inputId) {
        return new ResponseEntity<>(new CommonDto(authorService.findById(inputId), HttpStatus.OK.value(), "회원 상세조회 성공"), HttpStatus.OK);
    }

    // 비밀번호 변경

    // 회원탈퇴
}
