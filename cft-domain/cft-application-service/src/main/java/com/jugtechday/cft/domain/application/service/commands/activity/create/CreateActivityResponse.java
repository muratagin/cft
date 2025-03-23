package com.jugtechday.cft.domain.application.service.commands.activity.create;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class CreateActivityResponse {

    private final UUID id;
    private final UUID userId;
    private final UUID activityTypeId;
    private final ZonedDateTime occurredAt;
    private final Double calculatedEmission;
}
