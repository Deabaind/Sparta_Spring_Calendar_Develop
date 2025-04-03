package com.example.calendar_develop.entity;

import com.example.calendar_develop.dto.ScheduleDto.PutScheduleRequestDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@Table(name = "schedule")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    // 일정 id, 고유 값, 자동 생성

    private String userName;    // 작성자 이름

    private String title;   // 일정 제목
    private String contents;    // 일정 내용

    @Builder
    public Schedule(String userName, String title, String contents) {
        this.userName = userName;
        this.title = title;
        this.contents = contents;
    }

    // PutScheduleRequestDto 타입으로 Schedule 데이터를 수정하여 save 하기 위한 메서드
    public void update(PutScheduleRequestDto dto){
        this.userName = dto.getUserName();
        this.title = dto.getTitle();
        this.contents = dto.getContents();
    }
}
