package com.example.calendar_develop.Handler;

import com.example.calendar_develop.Exception.EmailOrPasswordNotFoundException;
import com.example.calendar_develop.Exception.ScheduleNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 예외 처리를 이곳에서 한다는 것
@ControllerAdvice
public class GlobalExceptionHandler {

    // EmailOrPasswordNotFoundException 이 발생하면 해당 메서드 호출
    @ExceptionHandler(EmailOrPasswordNotFoundException.class)
    public ResponseEntity<String> handleEmailOrPasswordNotFound(EmailOrPasswordNotFoundException exception) {
        // 401 오류코드 반환
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(exception.getMessage());
    }

    @ExceptionHandler(ScheduleNotFoundException.class)
    public ResponseEntity<String> handleScheduleNotFound(ScheduleNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}
