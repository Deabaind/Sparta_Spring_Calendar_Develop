package com.example.calendar_develop.service;

import com.example.calendar_develop.dto.*;
import com.example.calendar_develop.entity.Schedule;
import com.example.calendar_develop.repository.ScheduleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService{

    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public CreateResponseDto create(CreateRequestDto createRequestDto) {
        Schedule schedule = scheduleRepository.save(createRequestDto.createRequestDto());
        return new CreateResponseDto(schedule);
    }

    @Override
    public ResponseEntity<GetResponseDto> findById(Long id) {

        return null;
    }

    @Override
    public ResponseEntity<PutResponseDto> updateById(PutRequestDto putRequestDto) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
