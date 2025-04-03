package com.example.calendar_develop.dto;

import com.example.calendar_develop.entity.Schedule;
import lombok.Getter;

@Getter
public class CreateRequestDto {
    private String userName;
    private String title;
    private String contents;

    public Schedule createRequestDto() {
        return Schedule.builder()
                .userName(userName)
                .title(title)
                .contents(contents)
                .build();
    }
}
