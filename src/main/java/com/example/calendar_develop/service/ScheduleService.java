package com.example.calendar_develop.service;

import com.example.calendar_develop.dto.*;
import com.example.calendar_develop.entity.Schedule;

public interface ScheduleService {
    // 생성할 일정의 request 입력
    CreateResponseDto create(CreateRequestDto createRequestDto);
    // 찾을 id 입력
    Schedule findById(Long id);
    // 수정한 Schedule 타입의 객체(행)를 save
    PutResponseDto updateById(Schedule schedule);
    void deleteById(Long id);
}
