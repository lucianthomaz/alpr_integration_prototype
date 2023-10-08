package com.lucianthomaz.alpr.alprintegration.interactor.alert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.domain.Alert;
import com.lucianthomaz.alpr.alprintegration.domain.StatusEnum;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.AlertRepository;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.create.AlertCreationRequest;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.create.AlertCreationResponder;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.create.AlertCreationResponse;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.create.AlertCreationUseCase;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class AlertCreationInteractor implements AlertCreationUseCase {
    private final AlertRepository alertRepository;
    private final ObjectMapper objectMapper;

    @Override
    public void execute(AlertCreationRequest request, AlertCreationResponder responder) {
        Alert alert = objectMapper.convertValue(request, Alert.class);
        alert.setDateTime(LocalDateTime.now());
        alert.setStatus(StatusEnum.CREATED);
        alert = alertRepository.create(alert);
        AlertCreationResponse response = objectMapper.convertValue(alert, AlertCreationResponse.class);
        responder.onAccept(response);
    }
}
