package com.example.calendar_develop.service;

import com.example.calendar_develop.dto.ScheduleDto.CreateScheduleRequestDto;
import com.example.calendar_develop.dto.ScheduleDto.CreateScheduleResponseDto;
import com.example.calendar_develop.dto.ScheduleDto.PutScheduleResponseDto;
import com.example.calendar_develop.entity.Schedule;
import com.example.calendar_develop.entity.User;

public interface ScheduleService {
    // 생성할 일정의 request 입력
    CreateScheduleResponseDto create(CreateScheduleRequestDto createRequestDto, User user);
    // 찾을 id 입력
    Schedule findById(Long id);
    // 수정한 Schedule 타입의 객체(행)를 save
    PutScheduleResponseDto updateById(Schedule schedule);
    void deleteById(Long id);
}
