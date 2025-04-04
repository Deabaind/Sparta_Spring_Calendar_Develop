package com.example.calendar_develop.dto.ScheduleDto;

import com.example.calendar_develop.entity.Schedule;
import com.example.calendar_develop.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateScheduleResponseDto {

    private Long id;

    private String title;
    private String contents;

    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;


    public CreateScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.createDateTime = schedule.getCreateDateTime();
        this.updateDateTime = schedule.getUpdateDateTime();
    }
}
