package com.lucianthomaz.alpr.alprintegration.interactor.alert.create;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.domain.*;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.AlertRepository;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.UserRepository;
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
        List<UserAlert> userAlerts = sendToUserUseCase.execute(new SendToUserRequest(alert.getId(), List.of(2,3), null));
        List<User> usersNotified = userRepository.getUsers(userAlerts.stream().map(UserAlert::getUserId).toList());
        List<UserNotification> userNotifications = usersNotified.stream().map(user -> UserNotification.builder()
                .name(user.getName()).email(user.getEmail()).build()).toList();
        alert.setUsersNotified(userNotifications);
        AlertCreationResponse response = objectMapper.convertValue(alert, AlertCreationResponse.class);
        responder.onAccept(response);
    }
}