package com.example.calendar_develop.service;

import com.example.calendar_develop.dto.UserDto.*;
import com.example.calendar_develop.entity.User;
import com.example.calendar_develop.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public void login(String email, String password, HttpServletRequest request) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("아이디 또는 비밀번호가 틀렸습니다."));
        if(!password.equals(user.getPassword())) {
            throw new IllegalArgumentException("아이디 또는 비밀번호가 틀렸습니다.");
        }

        // request 에서 세션 객체를 가져오는 코드로 없다면 자동으로 생성해준다.
        HttpSession session = request.getSession();
        // 해당 유저가 로그인된 유저라고 Key 값으로 저장하는 코드
        session.setAttribute("loginUser", user);
    }

    @Override
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        // 만약 세션(세션 ID)이 비어있지 않다면 세션을 무효화한다.
        if (session != null) {
            session.invalidate();
        }

    }


}
