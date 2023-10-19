package com.lucianthomaz.alpr.alprintegration.interactor.alert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.domain.Alert;
import com.lucianthomaz.alpr.alprintegration.domain.StatusEnum;
import com.lucianthomaz.alpr.alprintegration.domain.UserAlert;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.AlertRepository;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.create.AlertCreationRequest;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.create.AlertCreationResponder;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.create.AlertCreationResponse;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.create.AlertCreationUseCase;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.sendtouser.SendToUserRequest;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.sendtouser.SendToUserUseCase;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
public class AlertCreationInteractor implements AlertCreationUseCase {
    private final AlertRepository alertRepository;
    private final ObjectMapper objectMapper;
    private final SendToUserUseCase sendToUserUseCase;

    @Override
    public void execute(AlertCreationRequest request, AlertCreationResponder responder) {
        Alert alert = objectMapper.convertValue(request, Alert.class);
        alert.setDateTime(LocalDateTime.now());
        alert.setStatus(StatusEnum.CREATED);
        alert = alertRepository.create(alert);
        List<UserAlert> userAlerts = sendToUserUseCase.execute(new SendToUserRequest(alert.getId(), List.of(1, 2), null));
        System.out.println("UserAlerts: " + userAlerts.toString());
        AlertCreationResponse response = objectMapper.convertValue(alert, AlertCreationResponse.class);
        responder.onAccept(response);
    }
}
