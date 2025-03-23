package com.jugtechday.cft.domain.core.entity;

import com.jugtechday.cft.domain.core.valueobject.UserId;

import java.time.ZonedDateTime;
import java.util.List;

public class UserDomainEntity extends AggregateRoot<UserId> {

    private final String fullName;
    private final String email;
    private final ZonedDateTime registrationDate;
    private List<ActivityDomainEntity> activities;

    public UserDomainEntity(String fullName, String email,
                            ZonedDateTime registrationDate,
                            List<ActivityDomainEntity> activities) {
        this.fullName = fullName;
        this.email = email;
        this.registrationDate = registrationDate;
        this.activities = activities;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public ZonedDateTime getRegistrationDate() {
        return registrationDate;
    }

    public List<ActivityDomainEntity> getActivities() {
        return activities;
    }

    public void setActivities(List<ActivityDomainEntity> activities) {
        this.activities = activities;
    }
}
