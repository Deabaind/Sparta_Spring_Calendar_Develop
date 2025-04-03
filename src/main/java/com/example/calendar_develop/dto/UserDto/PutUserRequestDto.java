package com.example.calendar_develop.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PutUserRequestDto {
    private String name;
    private String email;
    private String password;
}
