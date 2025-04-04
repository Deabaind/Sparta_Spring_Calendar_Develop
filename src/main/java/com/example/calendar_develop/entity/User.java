package com.example.calendar_develop.entity;

import com.example.calendar_develop.dto.UserDto.PutUserRequestDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String password;

    @Builder
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // PutUserRequestDto 타입으로 User 데이터를 수정하여 save 하기 위한 메서드
    public void update(PutUserRequestDto putUserRequestDto) {
        this.name = putUserRequestDto.getName();
        this.email = putUserRequestDto.getEmail();
        this.password = putUserRequestDto.getPassword();
    }
}
