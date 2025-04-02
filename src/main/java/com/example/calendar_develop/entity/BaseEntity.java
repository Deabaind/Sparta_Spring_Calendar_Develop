package com.example.calendar_develop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;

import java.time.LocalDateTime;

// 공통되는 작성, 수정일을 하위 클래스에 상속하기 위한 클래스
@Getter
@MappedSuperclass
public class BaseEntity {

    @Column(updatable = false)
    private LocalDateTime createDateTime;   // 작성일
    private LocalDateTime updateDateTime;   // 수정일

    // 작성일, 수정일을 현재 시간으로 변경하는 메서드
    @PrePersist
    public void prePersist(){
        LocalDateTime now = LocalDateTime.now();
        this.createDateTime = now;
        this.updateDateTime = now;
    }

    // 수정일을 현재 시간으로 변경하는 메서드
    @PreUpdate
    public void preUpdate() {
        this.updateDateTime = LocalDateTime.now();
    }
}
