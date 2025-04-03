package com.example.calendar_develop.dto.UserDto;

import lombok.Getter;

@Getter
public class LoginUserResponseDto {

    private final Long id;

    public LoginUserResponseDto(Long id) {
        this.id = id;
    }
}
