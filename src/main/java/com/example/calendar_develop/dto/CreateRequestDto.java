package com.example.calendar_develop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CreateRequestDto {
    private String userName;
    private String title;
    private String contents;

    private LocalDateTime createDateTime;
    private LocalDateTime updateDatetime;

}
