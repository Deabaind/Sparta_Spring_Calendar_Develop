package com.example.calendar_develop.dto.UserDto;

import com.example.calendar_develop.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateUserResponseDto {

    private Long id;

    private String name;
    private String email;

    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;

    public CreateUserResponseDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.createDateTime = user.getCreateDateTime();
        this.updateDateTime = user.getUpdateDateTime();
    }
}
