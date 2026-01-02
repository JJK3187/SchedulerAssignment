package com.scheduler.controller;

import com.scheduler.dto.CommentCreateRequest;
import com.scheduler.dto.CommentCreateResponse;
import com.scheduler.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("schedulers/{schedulerId}/comments")
    public ResponseEntity<CommentCreateResponse> commentCreate(
            @PathVariable Long schedulerId,
            @RequestBody CommentCreateRequest request
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.save(schedulerId, request));
    }

}
