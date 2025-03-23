package com.jugtechday.cft.presentation.rest;

import com.jugtechday.cft.domain.application.service.commands.activity.create.CreateActivityCommand;
import com.jugtechday.cft.domain.application.service.commands.activity.create.CreateActivityResponse;
import com.jugtechday.cft.domain.application.service.ports.input.service.ActivityApplicationService;
import com.jugtechday.cft.domain.application.service.queries.activity.getbyid.GetByIdActivityResponse;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/activities")
public class ActivityController {

    private final ActivityApplicationService activityApplicationService;

    public ActivityController(ActivityApplicationService activityApplicationService) {
        this.activityApplicationService = activityApplicationService;
    }

    @PostMapping
    public ResponseEntity<CreateActivityResponse> create(@RequestBody CreateActivityCommand createActivityCommand) {
        log.info("Creating activity for user id: {}", createActivityCommand.getUserId());
        CreateActivityResponse response = activityApplicationService.createActivity(createActivityCommand);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<GetByIdActivityResponse> getById(@PathVariable @NotNull @NotEmpty String id) {
        log.info("Getting activity with id: {}", id);
        GetByIdActivityResponse response = activityApplicationService.getById(UUID.fromString(id));
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public String get() {
        return "Hello";
    }
}
