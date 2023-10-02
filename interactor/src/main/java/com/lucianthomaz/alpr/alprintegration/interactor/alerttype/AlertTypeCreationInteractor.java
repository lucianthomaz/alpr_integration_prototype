package com.lucianthomaz.alpr.alprintegration.interactor.alerttype;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.domain.AlertType;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.AlertTypeRepository;
import com.lucianthomaz.alpr.alprintegration.usecase.alerttype.create.AlertTypeCreationRequest;
import com.lucianthomaz.alpr.alprintegration.usecase.alerttype.create.AlertTypeCreationResponder;
import com.lucianthomaz.alpr.alprintegration.usecase.alerttype.create.AlertTypeCreationResponse;
import com.lucianthomaz.alpr.alprintegration.usecase.alerttype.create.AlertTypeCreationUseCase;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AlertTypeCreationInteractor implements AlertTypeCreationUseCase {
    private final AlertTypeRepository alertTypeRepository;
    private final ObjectMapper objectMapper;
    @Override
    public void execute(AlertTypeCreationRequest request, AlertTypeCreationResponder responder) {
        AlertType alertType = objectMapper.convertValue(request, AlertType.class);
        alertType = alertTypeRepository.create(alertType);
        AlertTypeCreationResponse response = objectMapper.convertValue(alertType, AlertTypeCreationResponse.class);
        responder.onAccept(response);
    }
}
