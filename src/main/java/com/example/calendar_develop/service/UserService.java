package com.example.calendar_develop.service;

import com.example.calendar_develop.dto.UserDto.*;
import com.example.calendar_develop.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

public interface UserService {
    // 생성할 일정의 request 입력
    CreateUserResponseDto create(CreateUserRequestDto createUserRequestDto);
    // 찾을 id 입력
    User findById(Long id);
    // 수정한 Schedule 타입의 객체(행)를 save
    PutUserResponseDto updateById(User user);
    void deleteById(Long id);
    ResponseEntity<String> login(String email, String password, HttpServletRequest request);
    void logout(HttpServletRequest request);
}
