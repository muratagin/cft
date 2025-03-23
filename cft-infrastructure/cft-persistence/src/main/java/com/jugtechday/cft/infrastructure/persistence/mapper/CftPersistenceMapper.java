package com.jugtechday.cft.infrastructure.persistence.mapper;

import com.jugtechday.cft.domain.core.entity.ActivityDomainEntity;
import com.jugtechday.cft.domain.core.valueobject.ActivityId;
import com.jugtechday.cft.infrastructure.persistence.entity.ActivityEntity;
import com.jugtechday.cft.infrastructure.persistence.entity.ActivityTypeEntity;
import com.jugtechday.cft.infrastructure.persistence.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class CftPersistenceMapper {

    public ActivityDomainEntity activityEntityToActivityDomainEntity(ActivityEntity entity) {

        return new ActivityDomainEntity(new ActivityId(entity.getId()),
                entity.getUser().getId(),
                entity.getActivityType().getId(),
                entity.getOccurredAt(),
                entity.getCalculatedEmission()
        );
    }

    public ActivityEntity activityDomainEntityToActivityEntity(ActivityDomainEntity activityDomainEntity) {
        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setId(activityDomainEntity.getId().getValue());

        UserEntity user = new UserEntity();
        user.setId(activityDomainEntity.getUserId());
        activityEntity.setUser(user);

        ActivityTypeEntity activityType = new ActivityTypeEntity();
        activityType.setId(activityDomainEntity.getActivityTypeId());
        activityEntity.setActivityType(activityType);

        activityEntity.setOccurredAt(activityDomainEntity.getOccurredAt());
        activityEntity.setCalculatedEmission(activityDomainEntity.getCalculatedEmission());

        return activityEntity;
    }
}
