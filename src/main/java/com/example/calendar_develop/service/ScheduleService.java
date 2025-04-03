package com.example.calendar_develop.service;

import com.example.calendar_develop.dto.*;
import org.springframework.http.ResponseEntity;

public interface ScheduleService {
    CreateResponseDto create(CreateRequestDto createRequestDto);
    ResponseEntity<GetResponseDto> findById(Long id);
    ResponseEntity<PutResponseDto> updateById(PutRequestDto putRequestDto);
    void deleteById(Long id);
}
