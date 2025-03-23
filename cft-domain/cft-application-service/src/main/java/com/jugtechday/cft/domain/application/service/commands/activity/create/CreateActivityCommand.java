package com.jugtechday.cft.domain.application.service.commands.activity.create;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateActivityCommand {

    @NotNull
    private UUID userId;
    @NotNull
    private UUID activityTypeId;
    @NotNull
    private Double calculatedEmission;
}
