package com.jugtechday.cft.domain.application.service.mapper;

import com.jugtechday.cft.domain.application.service.commands.activity.create.CreateActivityCommand;
import com.jugtechday.cft.domain.application.service.commands.activity.create.CreateActivityResponse;
import com.jugtechday.cft.domain.application.service.queries.activity.getbyid.GetByIdActivityResponse;
import com.jugtechday.cft.domain.core.entity.ActivityDomainEntity;
import com.jugtechday.cft.domain.core.valueobject.ActivityId;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
public class CftDomainMapper {

    public ActivityDomainEntity createActivityCommandToActivityDomainEntity(CreateActivityCommand command,
                                                                            ZonedDateTime now) {
        return new ActivityDomainEntity(new ActivityId(null),
                command.getUserId(),
                command.getActivityTypeId(),
                now,
                command.getCalculatedEmission());
    }

    public CreateActivityResponse activityDomainEntityToCreateActivityResponse(ActivityDomainEntity activityDomainEntity) {

        return new CreateActivityResponse(activityDomainEntity.getId().getValue(),
                activityDomainEntity.getUserId(),
                activityDomainEntity.getActivityTypeId(),
                activityDomainEntity.getOccurredAt(),
                activityDomainEntity.getCalculatedEmission());
    }

    public GetByIdActivityResponse activityDomainEntityToGetByIdActivityResponse(ActivityDomainEntity activityDomainEntity) {
        return new GetByIdActivityResponse(activityDomainEntity.getId().getValue(),
                activityDomainEntity.getUserId(),
                activityDomainEntity.getActivityTypeId(),
                activityDomainEntity.getOccurredAt(),
                activityDomainEntity.getCalculatedEmission());
    }
}
