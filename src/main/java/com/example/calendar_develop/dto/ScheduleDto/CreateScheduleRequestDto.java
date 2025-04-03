package com.example.calendar_develop.dto.ScheduleDto;

import com.example.calendar_develop.entity.Schedule;
import lombok.Getter;

@Getter
public class CreateScheduleRequestDto {
    private String userName;
    private String title;
    private String contents;

    public Schedule createScheduleRequestDto() {
        return Schedule.builder()
                .userName(userName)
                .title(title)
                .contents(contents)
                .build();
    }
}
