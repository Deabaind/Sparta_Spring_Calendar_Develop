package com.example.calendar_develop.repository;

import com.example.calendar_develop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
