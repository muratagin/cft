package com.jugtechday.cft.domain.application.service.ports.input.service.impl;

import com.jugtechday.cft.domain.application.service.commands.activity.create.ActivityCreateCommandHandler;
import com.jugtechday.cft.domain.application.service.commands.activity.create.CreateActivityCommand;
import com.jugtechday.cft.domain.application.service.commands.activity.create.CreateActivityResponse;
import com.jugtechday.cft.domain.application.service.mapper.CftDomainMapper;
import com.jugtechday.cft.domain.application.service.ports.input.service.ActivityApplicationService;
import com.jugtechday.cft.domain.application.service.queries.activity.getbyid.ActivityGetByIdQueryHandler;
import com.jugtechday.cft.domain.application.service.queries.activity.getbyid.GetByIdActivityResponse;
import com.jugtechday.cft.domain.core.entity.ActivityDomainEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Slf4j
@Validated
@Service
public class ActivityApplicationServiceImpl implements ActivityApplicationService {

    private final ActivityGetByIdQueryHandler activityGetByIdQueryHandler;

    private final CftDomainMapper cftDomainMapper;

    private final ActivityCreateCommandHandler activityCreateCommandHandler;

    public ActivityApplicationServiceImpl(ActivityGetByIdQueryHandler activityGetByIdQueryHandler,
                                          CftDomainMapper cftDomainMapper,
                                          ActivityCreateCommandHandler activityCreateCommandHandler) {
        this.activityGetByIdQueryHandler = activityGetByIdQueryHandler;
        this.cftDomainMapper = cftDomainMapper;
        this.activityCreateCommandHandler = activityCreateCommandHandler;
    }

    @Override
    public CreateActivityResponse createActivity(CreateActivityCommand createActivityCommand) {
        ActivityDomainEntity createdActivity = activityCreateCommandHandler.createActivity(createActivityCommand);
        return cftDomainMapper.
                activityDomainEntityToCreateActivityResponse(createdActivity);
    }

    @Override
    public GetByIdActivityResponse getById(UUID id) {
        return activityGetByIdQueryHandler.getById(id);
    }
}
