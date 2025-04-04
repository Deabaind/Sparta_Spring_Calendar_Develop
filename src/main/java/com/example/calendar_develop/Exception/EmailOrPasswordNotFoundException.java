package com.example.calendar_develop.Exception;

public class EmailOrPasswordNotFoundException extends RuntimeException{
    public EmailOrPasswordNotFoundException(String message) {
        super(message);
    }
}
