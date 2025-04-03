package com.example.calendar_develop.repository;

import com.example.calendar_develop.dto.CreateRequestDto;
import com.example.calendar_develop.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
