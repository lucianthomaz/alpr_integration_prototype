package com.lucianthomaz.alpr.alprintegration.interactor.alert.create;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.domain.Alert;
import com.lucianthomaz.alpr.alprintegration.domain.StatusEnum;
import com.lucianthomaz.alpr.alprintegration.domain.User;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.AlertRepository;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.UserRepository;
import com.lucianthomaz.alpr.alprintegration.interactor.alert.shared.NotificationService;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.create.AlertCreationRequest;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.create.AlertCreationResponder;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.create.AlertCreationResponse;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.create.AlertCreationUseCase;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
public class AlertCreationInteractor implements AlertCreationUseCase {
    private final AlertRepository alertRepository;
    private final ObjectMapper objectMapper;
    private final UserRepository userRepository;

    private static final int SYSTEM = 1;
    @Override
    public void execute(AlertCreationRequest request, AlertCreationResponder responder) {
        Alert alert = objectMapper.convertValue(request, Alert.class);
        alert.setCreationDate(LocalDateTime.now());
        alert.setStatus(StatusEnum.CREATED.name());
        alert.setLastModifiedBy(SYSTEM);
        alert.setLastModified(LocalDateTime.now());
        alert = alertRepository.save(alert);
        requestUpdatedUsersLocation();
        AlertCreationResponse response = objectMapper.convertValue(alert, AlertCreationResponse.class);
        responder.onAccept(response);
    }

    private void requestUpdatedUsersLocation() {
        List<User> users = userRepository.getUsers();
        users.forEach(user -> NotificationService.sendPushNotification(
                user.getDeviceFcmToken(),
                "Location Request",
                "Please, provide your current location"));
    }
}