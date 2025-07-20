package com.beyond.basic_1.board_1.author.service;

import com.beyond.basic_1.board_1.author.authorDto.AuthorCreateDto;
import com.beyond.basic_1.board_1.author.authorDto.AuthorListDto;
import com.beyond.basic_1.board_1.author.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    // 회원가입
    public void save(AuthorCreateDto dto) {
        // 이메일 중복 검증
        if(authorRepository.findByEmail(dto.getEmail()).isPresent()) throw new IllegalArgumentException("중복된 이메일입니다."); // ToDo - 예외처리

        authorRepository.save(dto.toEntity());
    }

    // 회원목록 조회
    public List<AuthorListDto> findAll() {
        List<AuthorListDto> authorListDtos = authorRepository.findAll().stream().map(author -> AuthorListDto.fromEntity(author)).toList();
        return authorListDtos;
    }
}
