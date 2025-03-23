package com.jugtechday.cft.domain.application.service.commands.activity.create;

import com.jugtechday.cft.domain.application.service.mapper.CftDomainMapper;
import com.jugtechday.cft.domain.application.service.ports.output.repository.ActivityRepository;
import com.jugtechday.cft.domain.core.entity.ActivityDomainEntity;
import com.jugtechday.cft.domain.core.exception.RepositoryOutputPortException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Slf4j
@Component
public class ActivityCreateCommandHandler {

    private final ActivityRepository activityRepository;
    private final CftDomainMapper cftDomainMapper;

    public ActivityCreateCommandHandler(ActivityRepository activityRepository,
                                        CftDomainMapper cftDomainMapper) {
        this.activityRepository = activityRepository;
        this.cftDomainMapper = cftDomainMapper;
    }

    @Transactional
    public ActivityDomainEntity createActivity(CreateActivityCommand createActivityCommand) {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));
        ActivityDomainEntity domainEntity = cftDomainMapper.createActivityCommandToActivityDomainEntity(createActivityCommand, now);
        ActivityDomainEntity savedDomainEntity = activityRepository.create(domainEntity);
        if (savedDomainEntity == null) {
            log.error("Could not create activity");
            throw new RepositoryOutputPortException();
        }
        log.info("Returning ActivityDomainEntity for activity id: {}", savedDomainEntity.getId().getValue());
        return savedDomainEntity;
    }
}
