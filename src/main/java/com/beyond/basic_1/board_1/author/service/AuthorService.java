package com.beyond.basic_1.board_1.author.service;

import com.beyond.basic_1.board_1.author.authorDto.AuthorCreateDto;
import com.beyond.basic_1.board_1.author.authorDto.AuthorDetailDto;
import com.beyond.basic_1.board_1.author.authorDto.AuthorListDto;
import com.beyond.basic_1.board_1.author.entity.Author;
import com.beyond.basic_1.board_1.author.repository.AuthorRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthorService {
    public final AuthorRepository authorRepository;

    // 회원가입
    public void save(AuthorCreateDto authorCreateDto) {
        // 검증
        // 이메일 검증
        if (authorRepository.findByEmail(authorCreateDto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("중복되는 이메일입니다.");
        }
        // 비밀번호 검증
        if(authorCreateDto.getPassword().length() < 10) {
            throw new IllegalArgumentException("비밀번호 길이가 짧습니다.");
        }
        authorRepository.save(authorCreateDto.toEntity());
    }

    // 회원목록 조회
    public List<AuthorListDto> findAll() {
        return authorRepository.findAll().stream().map(a -> a.fromEntity()).collect(Collectors.toList());
    }

    // 회원 상세조회
    public AuthorDetailDto findById(Long inputId) {
        Author author = authorRepository.findById(inputId).orElseThrow(() -> new EntityNotFoundException("해당 회원이 존재하지 않습니다."));
        return AuthorDetailDto.fromEntity(author);
    }

    // 비밀번호 변경

    // 회원탈퇴
}
