package com.scheduler.dto;

import jakarta.persistence.Column;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SchedulerReponse {

    private final Long id;
    private final String contentsName;
    private final String contents;
    private final String name;
    private final String password;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;


    public SchedulerReponse(Long id, String contentsName, String contents, String name, String password, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.contentsName = contentsName;
        this.contents = contents;
        this.name = name;
        this.password = password;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
