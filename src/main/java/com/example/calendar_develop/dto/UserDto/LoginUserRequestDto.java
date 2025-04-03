package com.example.calendar_develop.dto.UserDto;

import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginUserRequestDto {

    @NotBlank
    private final String email;

    @NotBlank
    private final String password;
}
