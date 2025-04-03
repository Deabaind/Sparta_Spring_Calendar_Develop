package com.example.calendar_develop.controller;

import com.example.calendar_develop.dto.*;
import com.example.calendar_develop.entity.Schedule;
import com.example.calendar_develop.service.ScheduleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleServiceImpl scheduleService;

    public ScheduleController(ScheduleServiceImpl scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    public ResponseEntity<CreateResponseDto> create(@RequestBody CreateRequestDto createRequestDto) {
        CreateResponseDto createResponseDto = scheduleService.create(createRequestDto);
        return new ResponseEntity<>(createResponseDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetResponseDto> findById(@PathVariable Long id) {
        Schedule schedule = scheduleService.findById(id);
        // Schedule 타입을 dto 타입으로 변환 후 반환
        GetResponseDto getResponseDto = new GetResponseDto(schedule);
        return new ResponseEntity<>(getResponseDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PutResponseDto> updateById(@PathVariable Long id, @RequestBody PutRequestDto putRequestDto) {
        // 변환할 행 선택
        Schedule schedule = scheduleService.findById(id);
        // 선택한 행을 putRequestDto 로 수정
        schedule.update(putRequestDto);
        // 수정한 schedule 을 업데이트
        PutResponseDto putResponseDto = scheduleService.updateById(schedule);
        return new ResponseEntity<>(putResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deletebyId(@PathVariable Long id) {
        scheduleService.deleteById(id);
    }
}
