package com.scheduler.service;

import com.scheduler.dto.CommentCreateRequest;
import com.scheduler.dto.CommentCreateResponse;
import com.scheduler.entity.Comment;
import com.scheduler.entity.Scheduler;
import com.scheduler.repository.CommentRepository;
import com.scheduler.repository.SchedulerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final SchedulerRepository schedulerRepository;

    @Transactional
    public CommentCreateResponse save(Long schedulerId, CommentCreateRequest request) {
        // 게시글 확인
        Scheduler scheduler = schedulerRepository.findById(schedulerId).orElseThrow(
                () -> new RuntimeException("해당 게시글이 없습니다."));

        // 댓글 개수 제한 (10개)
        long commentCount = commentRepository.count();
        if (commentCount > 10) {
            throw new IllegalStateException("10개 이상 작성이 불가합니다.");
        }

        // 댓글 생성
        Comment comment = new Comment(
                request.getContents(),
                request.getName(),
                request.getPassword(),
                scheduler
        );

        // 댓글 저장
        Comment savedComment = commentRepository.save(comment);
        return new CommentCreateResponse(
                savedComment.getCommentId(),
                savedComment.getContents(),
                savedComment.getName(),
                savedComment.getScheduler(),
                savedComment.getCreatedAt(),
                savedComment.getModifiedAt()
        );
    }
}
