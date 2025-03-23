package com.jugtechday.cft.infrastructure.persistence.repository;

import com.jugtechday.cft.infrastructure.persistence.entity.ActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ActivityJpaRepository extends JpaRepository<ActivityEntity, UUID> {

}
