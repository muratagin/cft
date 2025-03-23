package com.jugtechday.cft.domain.core.entity;

import com.jugtechday.cft.domain.core.valueobject.ActivityTypeId;

public class ActivityTypeDomainEntity extends AggregateRoot<ActivityTypeId> {

    private final String name;
    private final String description;
    private final Double averageCarbonEmission;

    public ActivityTypeDomainEntity(String name, String description, Double averageCarbonEmission) {
        this.name = name;
        this.description = description;
        this.averageCarbonEmission = averageCarbonEmission;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getAverageCarbonEmission() {
        return averageCarbonEmission;
    }
}
