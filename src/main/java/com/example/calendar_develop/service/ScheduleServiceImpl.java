package com.example.calendar_develop.service;

import com.example.calendar_develop.dto.*;
import com.example.calendar_develop.entity.Schedule;
import com.example.calendar_develop.repository.ScheduleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.dao.EmptyResultDataAccessException;

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
    public Schedule findById(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                // id가 없다면
                .orElseThrow(() -> new EntityNotFoundException("일정을 찾을 수 없습니다."));
        return schedule;
    }

    @Override
    public PutResponseDto updateById(Schedule schedule) {
        Schedule updateSchedule = scheduleRepository.save(schedule);
        return new PutResponseDto(updateSchedule);
    }

    @Override
    public void deleteById(Long id) {
        try {
            scheduleRepository.deleteById(id);
        } catch (EmptyResultDataAccessException Exception) {
            System.out.println("일정을 찾을 수 없습니다.");
        }
    }
}
