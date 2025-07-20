package com.beyond.basic_1.board_1.post.controller;

import com.beyond.basic_1.board_1.common.CommonResponseDto;
import com.beyond.basic_1.board_1.post.postDto.PostCreateDto;
import com.beyond.basic_1.board_1.post.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    // 게시글 작성
    @PostMapping("/create")
    public ResponseEntity<?> createPost(@Valid @RequestBody PostCreateDto dto) {
        postService.save(dto);
        return new ResponseEntity<>(new CommonResponseDto(dto, "게시글 작성 성공", HttpStatus.CREATED.value()), HttpStatus.CREATED); // Todo - 매개변수
    }
}
