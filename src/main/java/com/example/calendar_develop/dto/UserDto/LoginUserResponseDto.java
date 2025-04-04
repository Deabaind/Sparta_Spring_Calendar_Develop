package com.example.calendar_develop.dto.UserDto;

import lombok.Getter;

@Getter
public class LoginUserResponseDto {

    private final Long id;
    private final String name;

    public LoginUserResponseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
