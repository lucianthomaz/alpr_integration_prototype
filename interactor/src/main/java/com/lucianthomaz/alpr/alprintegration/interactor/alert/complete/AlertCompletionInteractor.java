package com.lucianthomaz.alpr.alprintegration.interactor.alert.complete;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.domain.Alert;
import com.lucianthomaz.alpr.alprintegration.domain.StatusEnum;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.AlertRepository;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.complete.AlertCompletionRequest;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.complete.AlertCompletionResponder;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.complete.AlertCompletionResponse;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.complete.AlertCompletionUseCase;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class AlertCompletionInteractor implements AlertCompletionUseCase {
    private final AlertRepository alertRepository;
    private final ObjectMapper objectMapper;

    @Override
    public void execute(AlertCompletionRequest request, AlertCompletionResponder responder) {
        Alert alert = alertRepository.getDetails(request.alertId())
                .orElseThrow(() -> new RuntimeException("Alert not found"));
        alert.setLastModified(LocalDateTime.now());
        alert.setLastModifiedBy(request.userId());
        alert.setStatus(StatusEnum.FINISHED.name());
        alert = alertRepository.save(alert);
        AlertCompletionResponse response = objectMapper.convertValue(alert, AlertCompletionResponse.class);
        responder.onAccept(response);
    }
}
