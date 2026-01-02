package com.scheduler.service;

import com.scheduler.dto.*;
import com.scheduler.entity.Scheduler;
import com.scheduler.repository.SchedulerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SchedulerService {

    private final SchedulerRepository schedulerRepository;

    // Create
    @Transactional
    public SchedulerCreateResponse save(SchedulerCreateRequest request) {
        Scheduler scheduler = new Scheduler(
                request.getContentsName(),
                request.getContents(),
                request.getName(),
                request.getPassword()
        );
        Scheduler saveScheduler = schedulerRepository.save(scheduler);
        return new SchedulerCreateResponse(
                saveScheduler.getId(),
                saveScheduler.getContentsName(),
                saveScheduler.getContents(),
                saveScheduler.getName(),
                saveScheduler.getCreatedAt(),
                saveScheduler.getModifiedAt()
        );
    }

    // Read 전체
    @Transactional(readOnly = true)
    public List<SchedulerGetResponse> findAll(String name) {
        List<Scheduler> schedulers;

        // name 이 비어있지 않다면 name으로 검색
        if (!name.isEmpty()) {
            schedulers = schedulerRepository.findByNameOrderByModifiedAtDesc(name);
        } else {
            schedulers = schedulerRepository.findAll();
        }

        List<SchedulerGetResponse> dtos = new ArrayList<>();
        for (Scheduler scheduler : schedulers) {
            SchedulerGetResponse response = new SchedulerGetResponse(
                    scheduler.getId(),
                    scheduler.getContentsName(),
                    scheduler.getContents(),
                    scheduler.getName(),
                    scheduler.getCreatedAt(),
                    scheduler.getModifiedAt()
            );
            dtos.add(response);
        }
        return dtos;
    }

    // Read 단건
    @Transactional(readOnly = true)
    public SchedulerGetResponse findOne(Long schedulerId){
        Scheduler scheduler = schedulerRepository.findById(schedulerId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 게시글 입니다.")
        );
        return new SchedulerGetResponse(
                scheduler.getId(),
                scheduler.getContentsName(),
                scheduler.getContents(),
                scheduler.getName(),
                scheduler.getCreatedAt(),
                scheduler.getModifiedAt()
        );
    }

    // Update
    @Transactional
    public SchedulerUpdateResponse update(Long schedulerId, String password, SchedulerUpdateRequest request) {
        Scheduler scheduler = schedulerRepository.findById(schedulerId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 게시글 입니다.")
        );
        // 비밀번호 확인
        if (!scheduler.getPassword().equals(password)) {
            throw new IllegalStateException("비밀번호가 틀립니다.");
        }

        scheduler.update(
                request.getContentsName(),
                request.getName()
        );
        return new SchedulerUpdateResponse(
                scheduler.getId(),
                scheduler.getContentsName(),
                scheduler.getContents(),
                scheduler.getName(),
                scheduler.getCreatedAt(),
                scheduler.getModifiedAt()
        );
    }

    // Delete
    @Transactional
    public void delete(Long schedulerId, String password) {
        Scheduler scheduler = schedulerRepository.findById(schedulerId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 게시글 입니다.")
        );
        // 비밀번호 확인
        if (!scheduler.getPassword().equals(password)) {
            throw new IllegalStateException("비밀번호가 틀립니다.");
        }
        schedulerRepository.deleteById(schedulerId);
    }
}
