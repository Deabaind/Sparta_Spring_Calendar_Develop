package com.example.calendar_develop.dto.ScheduleDto;

import com.example.calendar_develop.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PutScheduleResponseDto {

    private String userName;
    private String title;
    private String contents;

    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;

    public PutScheduleResponseDto(Schedule schedule) {
        this.userName = schedule.getUserName();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.createDateTime = schedule.getCreateDateTime();
        this.updateDateTime = schedule.getUpdateDateTime();
    }
}
