package com.example.calendar_develop.dto.UserDto;

import com.example.calendar_develop.entity.User;
import lombok.Getter;

@Getter
public class CreateUserRequestDto {

    private String name;
    private String email;
    private String password;

    public User createUserRequestDto() {
        return User.builder()
                .name(name)
                .email(email)
                .password(password)
                .build();
    }
}
