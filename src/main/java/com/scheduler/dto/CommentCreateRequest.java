package com.scheduler.dto;

import lombok.Getter;

@Getter
public class CommentCreateRequest {

    private String contents;
    private String name;
    private String password;
}
