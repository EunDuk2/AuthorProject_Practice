package com.beyond.basic_1.board_1.author.entity;

import com.beyond.basic_1.board_1.common.BaseEntityForTime;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Author extends BaseEntityForTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, nullable = false) // 예외처리를 위한 옵션이 아닌 테이블 데이터 옵션
    private String name;
    @Column(length = 100, unique = true, nullable = false)
    private String email;
    @Column(length = 100, nullable = false)
    private String password;
}
