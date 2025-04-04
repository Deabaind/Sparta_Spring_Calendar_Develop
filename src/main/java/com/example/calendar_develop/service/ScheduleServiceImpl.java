package com.example.calendar_develop.service;

import com.example.calendar_develop.dto.ScheduleDto.CreateScheduleRequestDto;
import com.example.calendar_develop.dto.ScheduleDto.CreateScheduleResponseDto;
import com.example.calendar_develop.dto.ScheduleDto.PutScheduleRequestDto;
import com.example.calendar_develop.dto.ScheduleDto.PutScheduleResponseDto;
import com.example.calendar_develop.entity.Schedule;
import com.example.calendar_develop.entity.User;
import com.example.calendar_develop.repository.ScheduleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.dao.EmptyResultDataAccessException;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public CreateScheduleResponseDto create(CreateScheduleRequestDto createRequestDto, User user) {
        Schedule schedule = new Schedule(createRequestDto, user);
        CreateScheduleResponseDto createScheduleResponseDto = new CreateScheduleResponseDto(scheduleRepository.save(schedule));
        return createScheduleResponseDto;
    }

    @Override
    public Schedule findById(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                // id가 없다면
                .orElseThrow(() -> new EntityNotFoundException("일정을 찾을 수 없습니다."));
        return schedule;
    }

    @Override
    public PutScheduleResponseDto updateById(Schedule schedule) {
        PutScheduleResponseDto putScheduleResponseDto = new PutScheduleResponseDto(scheduleRepository.save(schedule));
        return putScheduleResponseDto;
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
