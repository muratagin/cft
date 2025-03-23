package com.jugtechday.cft.domain.application.service.ports.input.service;
import com.jugtechday.cft.domain.application.service.commands.activity.create.CreateActivityCommand;
import com.jugtechday.cft.domain.application.service.commands.activity.create.CreateActivityResponse;

import com.jugtechday.cft.domain.application.service.queries.activity.getbyid.GetByIdActivityResponse;
import jakarta.validation.Valid;

import java.util.UUID;

public interface ActivityApplicationService {

    GetByIdActivityResponse getById(UUID id);

    CreateActivityResponse createActivity(@Valid CreateActivityCommand createActivityCommand);
}
