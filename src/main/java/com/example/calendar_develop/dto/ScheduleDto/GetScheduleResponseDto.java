package com.example.calendar_develop.dto.ScheduleDto;

import com.example.calendar_develop.entity.Schedule;
import com.example.calendar_develop.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetScheduleResponseDto {

    private String title;
    private String contents;

    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;

    public GetScheduleResponseDto(Schedule schedule) {
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.createDateTime = schedule.getCreateDateTime();
        this.updateDateTime = schedule.getUpdateDateTime();
    }
}
