package com.jugtechday.cft.domain.application.service.queries.activity.getbyid;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class GetByIdActivityResponse {

    private final UUID id;
    private final UUID userId;
    private final UUID activityTypeId;
    private final ZonedDateTime occurredAt;
    private final Double calculatedEmission;
}