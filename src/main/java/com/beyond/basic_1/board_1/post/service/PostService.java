package com.beyond.basic_1.board_1.post.service;

import com.beyond.basic_1.board_1.author.entity.Author;
import com.beyond.basic_1.board_1.author.repository.AuthorRepository;
import com.beyond.basic_1.board_1.post.entity.Post;
import com.beyond.basic_1.board_1.post.postDto.PostCreateDto;
import com.beyond.basic_1.board_1.post.postDto.PostListDto;
import com.beyond.basic_1.board_1.post.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final AuthorRepository authorRepository;

    // 게시글 작성
    public void save(PostCreateDto dto) {
        Author author = authorRepository.findById(dto.getAuthorId()).orElseThrow(() -> new EntityNotFoundException("없는 회원 ID 입니다."));
        postRepository.save(dto.toEntity(author));
    }

    // 게시글목록 조회
    public List<PostListDto> findAll() {
        List<PostListDto> postListDtos = postRepository.findAll().stream().map(post -> PostListDto.fromEntity(post)).toList();
        return postListDtos;
    }
}
