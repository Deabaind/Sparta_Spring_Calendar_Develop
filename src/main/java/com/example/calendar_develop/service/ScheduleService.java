package com.example.calendar_develop.service;

import com.example.calendar_develop.dto.CreateRequestDto;
import com.example.calendar_develop.dto.CreateResponseDto;
import org.springframework.http.ResponseEntity;

public interface ScheduleService {
    ResponseEntity<CreateResponseDto> create(CreateRequestDto createRequestDto);
    ResponseEntity<GetResponseDto> findById(Long id);
    ResponseEntity<PutResponseDto> updateById(PutRequestDto);
    void deleteById(Long id);

}
