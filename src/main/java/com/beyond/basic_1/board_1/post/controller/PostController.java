package com.beyond.basic_1.board_1.post.controller;

import com.beyond.basic_1.board_1.common.CommonResponseDto;
import com.beyond.basic_1.board_1.post.postDto.PostCreateDto;
import com.beyond.basic_1.board_1.post.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    // 게시글 작성
    @PostMapping("/create")
    public ResponseEntity<?> createPost(@Valid @RequestBody PostCreateDto dto) {
        postService.save(dto);
        return new ResponseEntity<>(new CommonResponseDto(dto, "게시글 작성 성공", HttpStatus.CREATED.value()), HttpStatus.CREATED);
    }

    // 게시글목록 조회
    @GetMapping("/list")
    public ResponseEntity<?> getPostList(@PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.DESC)Pageable pageable) {
        return new ResponseEntity<>(new CommonResponseDto(postService.findAll(pageable), "게시글목록 조회 성공", HttpStatus.OK.value()), HttpStatus.OK);
    }

    // 게시글상세 조회
    @GetMapping("/detail/{inputId}")
    public ResponseEntity<?> getPostDetail(@PathVariable Long inputId) {
        return new ResponseEntity<>(new CommonResponseDto(postService.findById(inputId), "게시글상세 조회 성공", HttpStatus.OK.value()), HttpStatus.OK);
    }
}
