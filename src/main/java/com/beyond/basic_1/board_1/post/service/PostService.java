package com.beyond.basic_1.board_1.post.service;

import com.beyond.basic_1.board_1.post.entity.Post;
import com.beyond.basic_1.board_1.post.postDto.PostCreateDto;
import com.beyond.basic_1.board_1.post.postDto.PostListDto;
import com.beyond.basic_1.board_1.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    // 게시글 작성
    public void save(PostCreateDto postCreateDto) {
        // 검증

        // 저장
        Post post = postCreateDto.toEntity();
        postRepository.save(post);
    }

    // 게시글 목록 조회
    public List<PostListDto> findAll() {
        return postRepository.findAll().stream().map(a -> a.fromEntity()).toList();
    }
}
