package com.example.calendar_develop.controller;

import com.example.calendar_develop.dto.UserDto.*;
import com.example.calendar_develop.entity.User;
import com.example.calendar_develop.service.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public void login(@RequestBody LoginUserRequestDto RequestDto, HttpServletRequest request) {
        userService.login(RequestDto.getEmail(), RequestDto.getPassword(), request);
    }

    @PostMapping
    public ResponseEntity<CreateUserResponseDto> create(@RequestBody CreateUserRequestDto createUserRequestDto) {
        CreateUserResponseDto createUserResponseDto = userService.create(createUserRequestDto);
        return new ResponseEntity<>(createUserResponseDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetUserResponseDto> findById(@PathVariable Long id) {
        User user = userService.findById(id);
        GetUserResponseDto getUserResponseDto = new GetUserResponseDto(user);
        return new ResponseEntity<>(getUserResponseDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PutUserResponseDto> updateById(@PathVariable Long id, @RequestBody PutUserRequestDto putUserRequestDto) {
        User user = userService.findById(id);
        user.update(putUserRequestDto);
        PutUserResponseDto putUserResponseDto = userService.updateById(user);
        return new ResponseEntity<>(putUserResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }



}
