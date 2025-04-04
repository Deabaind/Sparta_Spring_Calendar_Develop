package com.example.calendar_develop.entity;

import com.example.calendar_develop.dto.ScheduleDto.CreateScheduleRequestDto;
import com.example.calendar_develop.dto.ScheduleDto.PutScheduleRequestDto;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Table(name = "schedule")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    // 일정 id, 고유 값, 자동 생성

    @ManyToOne
    @JoinColumn(name = "userId")
    // FK가 아닌 User 객체 자체를 참조하는 것이 JPA 방식이기 때문
    private User user;    // 유저 테이블 Id

    private String title;   // 일정 제목
    private String contents;    // 일정 내용

    public Schedule(CreateScheduleRequestDto dto, User user) {
        this.user = user;
        this.title = dto.getTitle();
        this.contents = dto.getContents();
    }

    // PutScheduleRequestDto 타입으로 Schedule 데이터를 수정하여 save 하기 위한 메서드
    public void update(PutScheduleRequestDto dto) {
        this.title = dto.getTitle();
        this.contents = dto.getContents();
    }


}
