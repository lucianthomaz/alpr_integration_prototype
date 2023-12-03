package com.lucianthomaz.alpr.alprintegration.interactor.alert.monitor;

import com.lucianthomaz.alpr.alprintegration.domain.Alert;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.AlertRepository;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.sendtouser.SendToUserRequest;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.sendtouser.SendToUserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class NotificationMonitor {
    private final AlertRepository alertRepository;
    private final SendToUserUseCase sendToUserUseCase;

    @Scheduled(fixedDelay = 10000)
    public void sendNotificationForCreatedAlerts() {
        List<Alert> alerts = alertRepository.getAlertsPendingToSendNotification();
        alerts.forEach(alert -> sendToUserUseCase.execute(new SendToUserRequest(alert.getId(), new ArrayList<>(), null)));
    }
}
