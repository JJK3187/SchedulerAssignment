package com.scheduler.controller;

import com.scheduler.dto.*;
import com.scheduler.service.SchedulerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/schedulers")
    public ResponseEntity<List<SchedulerGetResponse>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(schedulerService.findAll());
    }

    @GetMapping("/schedulers/{schedulerId}")
    public ResponseEntity<SchedulerGetResponse> getOne(
            @PathVariable Long schedulerId
    ){
        return ResponseEntity.status(HttpStatus.OK).body(schedulerService.findOne(schedulerId));
    }

    @PutMapping("/schedulers/{schedulerId}")
    public ResponseEntity<SchedulerUpdateResponse> update(
            @PathVariable Long schedulerId,
            @RequestParam String password,
            @RequestBody SchedulerUpdateRequest request
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(schedulerService.update(schedulerId, password, request));
    }

    @DeleteMapping("/schedulers/{schedulerId}")
    public ResponseEntity<Void> delete(
            @PathVariable Long schedulerId,
            @RequestParam String password
    ) {
        schedulerService.delete(schedulerId, password);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
