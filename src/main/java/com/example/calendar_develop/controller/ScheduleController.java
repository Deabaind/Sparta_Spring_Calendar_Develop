package com.example.calendar_develop.controller;

import com.example.calendar_develop.dto.CreateRequestDto;
import com.example.calendar_develop.dto.CreateResponseDto;
import com.example.calendar_develop.service.ScheduleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return new ResponseEntity<>(createResponseDto, HttpStatus.CREATED.OK);
    }
}
