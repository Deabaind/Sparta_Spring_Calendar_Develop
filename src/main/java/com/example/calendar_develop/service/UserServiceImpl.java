package com.example.calendar_develop.service;

import com.example.calendar_develop.Exception.EmailOrPasswordNotFoundException;
import com.example.calendar_develop.Exception.UserNotFoundException;
import com.example.calendar_develop.dto.UserDto.*;
import com.example.calendar_develop.entity.User;
import com.example.calendar_develop.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
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
        if(!userRepository.existsById(id)) {
            throw new UserNotFoundException("유저를 찾을 수 없습니다.");
        }
        userRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<String> login(String email, String password, HttpServletRequest request) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EmailOrPasswordNotFoundException("아이디 또는 비밀번호가 틀렸습니다."));
        if(!password.equals(user.getPassword())) {
            throw new EmailOrPasswordNotFoundException("아이디 또는 비밀번호가 틀렸습니다.");
        }

        // request 에서 세션 객체를 가져오는 코드로 없다면 자동으로 생성해준다.
        HttpSession session = request.getSession();
        // 해당 유저가 로그인된 유저라고 Key 값으로 저장하는 코드
        session.setAttribute("loginUser", user);
        return ResponseEntity.ok("로그인 되었습니다.");
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
