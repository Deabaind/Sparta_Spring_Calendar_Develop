package com.example.calendar_develop.dto.UserDto;

import com.example.calendar_develop.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetUserResponseDto {

    private String name;
    private String email;

    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;

    public GetUserResponseDto(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.createDateTime = user.getCreateDateTime();
        this.updateDateTime = user.getUpdateDateTime();
    }
}
