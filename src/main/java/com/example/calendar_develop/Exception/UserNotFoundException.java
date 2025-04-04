package com.example.calendar_develop.Exception;

import org.springframework.http.ResponseEntity;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message){
        super(message);
    }
}
