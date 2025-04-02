package com.example.calendar_develop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PutRequestDto {
    private String userName;
    private String title;
    private String contents;
}
