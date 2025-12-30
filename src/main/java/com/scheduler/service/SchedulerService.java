package com.scheduler.service;

import com.scheduler.dto.SchedulerCreateReponse;
import com.scheduler.dto.SchedulerCreateRequest;
import com.scheduler.entity.Scheduler;
import com.scheduler.repository.SchedulerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
                saveScheduler.getPassword(),
                saveScheduler.getCreatedAt(),
                saveScheduler.getModifiedAt()
        );
    }
}
