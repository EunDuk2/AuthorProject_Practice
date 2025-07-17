package com.beyond.basic_1.board_1.author.entity;

import com.beyond.basic_1.board_1.author.authorDto.AuthorListDto;
import com.beyond.basic_1.board_1.author.authorEnum.AuthorState;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class Author {
    // Field
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 100, unique = true, nullable = false)
    private String email;

    @Setter
    @Column(length = 100, nullable = false)
    private String password;

    @CreationTimestamp
    private LocalDateTime createdTime;

    @UpdateTimestamp
    private LocalDateTime updatedTime;

    @Setter
    @Enumerated(EnumType.STRING)
    private AuthorState state = AuthorState.NORMAL;

    // Constructor
    public Author(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // fromEntity
    public AuthorListDto fromEntity() {
        return new AuthorListDto(this.id, this.name);
    }
}
