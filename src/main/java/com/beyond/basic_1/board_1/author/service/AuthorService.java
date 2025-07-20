package com.beyond.basic_1.board_1.author.service;

import com.beyond.basic_1.board_1.author.authorDto.AuthorCreateDto;
import com.beyond.basic_1.board_1.author.authorDto.AuthorDetailDto;
import com.beyond.basic_1.board_1.author.authorDto.AuthorListDto;
import com.beyond.basic_1.board_1.author.entity.Author;
import com.beyond.basic_1.board_1.author.repository.AuthorRepository;
import jakarta.persistence.EntityNotFoundException;
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
        if(authorRepository.findByEmail(dto.getEmail()).isPresent()) throw new IllegalArgumentException("중복된 이메일입니다.");

        authorRepository.save(dto.toEntity());
    }

    // 회원목록 조회
    public List<AuthorListDto> findAll() {
        List<AuthorListDto> authorListDtos = authorRepository.findAll().stream().map(author -> AuthorListDto.fromEntity(author)).toList();
        return authorListDtos;
    }

    // 회원상세 조회
    public AuthorDetailDto findById(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("없는 회원 ID 입니다."));
        return AuthorDetailDto.fromEntity(author);
    }
}
