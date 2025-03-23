package com.jugtechday.cft.domain.application.service.queries.activity.getbyid;

import com.jugtechday.cft.domain.application.service.mapper.CftDomainMapper;
import com.jugtechday.cft.domain.application.service.ports.output.repository.ActivityRepository;
import com.jugtechday.cft.domain.core.entity.ActivityDomainEntity;
import com.jugtechday.cft.domain.core.exception.DomainEntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class ActivityGetByIdQueryHandler {

    private final ActivityRepository activityRepository;
    private final CftDomainMapper cftDomainMapper;

    public ActivityGetByIdQueryHandler(
            ActivityRepository activityRepository,
            CftDomainMapper cftDomainMapper) {
        this.activityRepository = activityRepository;
        this.cftDomainMapper = cftDomainMapper;
    }

    public GetByIdActivityResponse getById(UUID id) {
        Optional<ActivityDomainEntity> activityDomainEntityOptional = activityRepository.getById(id);
        if (activityDomainEntityOptional.isEmpty()) {
            log.error("Could not find activity by id: {}", id);
            throw new DomainEntityNotFoundException();
        }
        return cftDomainMapper.activityDomainEntityToGetByIdActivityResponse(activityDomainEntityOptional.get());
    }
}
