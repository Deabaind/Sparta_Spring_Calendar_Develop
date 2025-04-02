package com.example.calendar_develop.dto;

import com.example.calendar_develop.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateResponseDto {
    private Long id;

    private String userName;
    private String title;
    private String contents;

    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;

    public CreateResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.userName = schedule.getUserName();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.createDateTime = schedule.getCreateDateTime();
        this.updateDateTime = schedule.getUpdateDateTime();
    }
}
