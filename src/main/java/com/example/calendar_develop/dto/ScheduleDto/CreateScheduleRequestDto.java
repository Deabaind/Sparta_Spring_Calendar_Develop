package com.example.calendar_develop.dto.ScheduleDto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateScheduleRequestDto {
    private String title;
    private String contents;

    public CreateScheduleRequestDto(CreateScheduleRequestDto createScheduleRequestDto) {
        this.title = createScheduleRequestDto.getTitle();
        this.contents = createScheduleRequestDto.getContents();
    }
}
