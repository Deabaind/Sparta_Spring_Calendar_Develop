package com.example.calendar_develop.dto.ScheduleDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PutScheduleRequestDto {
    private Long id;
    private String title;
    private String contents;

}
