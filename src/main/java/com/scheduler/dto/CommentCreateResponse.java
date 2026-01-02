package com.scheduler.dto;

import com.scheduler.entity.Scheduler;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentCreateResponse {

    private final Long commentId;
    private final String contents;
    private final String name;
    private final Scheduler scheduler;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public CommentCreateResponse(Long commentId, String contents, String name, Scheduler scheduler, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.commentId = commentId;
        this.contents = contents;
        this.name = name;
        this.scheduler = scheduler;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
