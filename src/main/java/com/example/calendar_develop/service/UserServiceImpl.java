package com.example.calendar_develop.service;

import com.example.calendar_develop.dto.UserDto.CreateUserRequestDto;
import com.example.calendar_develop.dto.UserDto.CreateUserResponseDto;
import com.example.calendar_develop.dto.UserDto.PutUserResponseDto;
import com.example.calendar_develop.entity.User;
import com.example.calendar_develop.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CreateUserResponseDto create(CreateUserRequestDto createUserRequestDto) {
        User user = userRepository.save(createUserRequestDto.createUserRequestDto());
        return new CreateUserResponseDto(user);
    }

    @Override
    public User findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("유저를 찾을 수 없습니다."));
        return user;
    }

    @Override
    public PutUserResponseDto updateById(User user) {
        User updateUser = userRepository.save(user);
        return new PutUserResponseDto(updateUser);
    }

    @Override
    public void deleteById(Long id) {
        try {
            userRepository.deleteById(id);
        }   catch (EmptyResultDataAccessException Exception) {
            System.out.println("일정을 찾을 수 없습니다.");
        }

    }
}
