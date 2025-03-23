package com.jugtechday.cft.infrastructure.persistence.adapter;

import com.jugtechday.cft.domain.application.service.ports.output.repository.ActivityRepository;
import com.jugtechday.cft.domain.core.entity.ActivityDomainEntity;
import com.jugtechday.cft.infrastructure.persistence.entity.ActivityEntity;
import com.jugtechday.cft.infrastructure.persistence.mapper.CftPersistenceMapper;
import com.jugtechday.cft.infrastructure.persistence.repository.ActivityJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class ActivityRepositoryImpl implements ActivityRepository {

    private final ActivityJpaRepository activityJpaRepository;
    private final CftPersistenceMapper cftPersistenceMapper;

    public ActivityRepositoryImpl(ActivityJpaRepository activityJpaRepository,
                                  CftPersistenceMapper cftPersistenceMapper) {
        this.activityJpaRepository = activityJpaRepository;
        this.cftPersistenceMapper = cftPersistenceMapper;
    }

    @Override
    public ActivityDomainEntity create(ActivityDomainEntity entity) {
        return cftPersistenceMapper.activityEntityToActivityDomainEntity(activityJpaRepository.save
                (cftPersistenceMapper.activityDomainEntityToActivityEntity(entity)));
    }

    @Override
    public Optional<ActivityDomainEntity> getById(UUID id) {
        Optional<ActivityEntity> activityEntityOptional = activityJpaRepository.findById(id);
        return activityEntityOptional.map(cftPersistenceMapper::activityEntityToActivityDomainEntity);
    }
}
