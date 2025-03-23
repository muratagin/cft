package com.jugtechday.cft.domain.core.entity;

import com.jugtechday.cft.domain.core.valueobject.ActivityId;

import java.time.ZonedDateTime;
import java.util.UUID;

public class ActivityDomainEntity extends BaseDomainEntity<ActivityId> {

    private final UUID userId;
    private final UUID activityTypeId;
    private final ZonedDateTime occurredAt;
    private final Double calculatedEmission;

    public ActivityDomainEntity(ActivityId activityId, UUID userId, UUID activityTypeId,
                                ZonedDateTime occurredAt, Double calculatedEmission) {
        this.setId(activityId);
        this.userId = userId;
        this.activityTypeId = activityTypeId;
        this.occurredAt = occurredAt;
        this.calculatedEmission = calculatedEmission;
    }

    public UUID getUserId() {
        return userId;
    }

    public UUID getActivityTypeId() {
        return activityTypeId;
    }

    public ZonedDateTime getOccurredAt() {
        return occurredAt;
    }

    public Double getCalculatedEmission() {
        return calculatedEmission;
    }
}
