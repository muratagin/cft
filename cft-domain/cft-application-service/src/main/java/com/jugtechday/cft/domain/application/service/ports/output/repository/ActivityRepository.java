package com.jugtechday.cft.domain.application.service.ports.output.repository;

import com.jugtechday.cft.domain.core.entity.ActivityDomainEntity;

import java.util.Optional;
import java.util.UUID;

public interface ActivityRepository {

    ActivityDomainEntity create(ActivityDomainEntity entity);

    Optional<ActivityDomainEntity> getById(UUID id);
}
