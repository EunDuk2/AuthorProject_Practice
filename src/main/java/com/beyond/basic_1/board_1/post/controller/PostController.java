package com.beyond.basic_1.board_1.post.controller;

import com.beyond.basic_1.board_1.common.CommonDto;
import com.beyond.basic_1.board_1.post.postDto.PostCreateDto;
import com.beyond.basic_1.board_1.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    // 게시글 작성
    @PostMapping("/create")
    public ResponseEntity<?> save(@RequestBody PostCreateDto postCreateDto) {
        postService.save(postCreateDto);
        return new ResponseEntity<>(new CommonDto(postCreateDto, HttpStatus.OK.value(), "게시글 작성 성공"), HttpStatus.OK);
    }

    // 게시글 목록 조회
}
