package com.example.calendar_develop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor // JPA 용 기본 생성자 생성
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;    // 일정 id, 고유 값, 자동 생성

    private String userName;    // 작성자 이름
    private String title;   // 일정 제목
    private String contents;    // 일정 내용

}
