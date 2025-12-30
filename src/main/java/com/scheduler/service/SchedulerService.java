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


    @Transactional
    public SchedulerCreateReponse save(SchedulerCreateRequest request) {
        Scheduler scheduler = new Scheduler(
                request.getContentsName(),
                request.getContents(),
                request.getName(),
                request.getPassword()
        );
        Scheduler saveScheduler = schedulerRepository.save(scheduler);
        return new SchedulerCreateReponse(
                saveScheduler.getId(),
                saveScheduler.getContentsName(),
                saveScheduler.getContents(),
                saveScheduler.getName(),
                saveScheduler.getCreatedAt(),
                saveScheduler.getModifiedAt()
        );
    }
    @Transactional(readOnly = true)
    public List<SchedulerGetResponse> findAll() {
        List<Scheduler> schedulers = schedulerRepository.findAll();
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

    @Transactional
    public SchedulerUpdateResponse update(Long schedulerId, SchedulerUpdateRequest request) {
        Scheduler scheduler = schedulerRepository.findById(schedulerId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 게시글 입니다.")
        );
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
}
