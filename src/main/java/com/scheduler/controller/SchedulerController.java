package com.scheduler.controller;

import com.scheduler.dto.SchedulerCreateReponse;
import com.scheduler.dto.SchedulerCreateRequest;
import com.scheduler.service.SchedulerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SchedulerController {

    private final SchedulerService schedulerService;

    @PostMapping("/schedulers")
    public ResponseEntity<SchedulerCreateReponse> create(
            @RequestBody SchedulerCreateRequest request
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(schedulerService.save(request));
    }
}
