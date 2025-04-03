package com.example.calendar_develop.dto;

import com.example.calendar_develop.entity.Schedule;
import lombok.Getter;

@Getter
public class PutRequestDto {
    private Long id;
    private String userName;
    private String title;
    private String contents;

//    public Schedule putRequestDto(Long id) {
//        return Schedule.builder()
//                .userName(userName)
//                .title(title)
//                .contents(contents)
//                .build();
//    }

//    public PutRequestDto(Long id, String userName, String title, String contents) {
//        this.id = id;
//        this.userName = userName;
//        this.title = title;
//        this.contents = contents;
//    }
}
