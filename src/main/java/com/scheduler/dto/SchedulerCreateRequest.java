package com.scheduler.dto;

import lombok.Getter;

@Getter
public class SchedulerCreateRequest {

    private String contentsName;
    private String contents;
    private String name;
    private String password;
}
