package com.lucianthomaz.alpr.alprintegration.interactor.alert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.domain.Alert;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.AlertRepository;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.visualize.UserAlertResponse;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.visualize.VisualizeAlertsResponder;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.visualize.VisualizeAlertsResponse;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.visualize.VisualizeAlertsUseCase;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class VisualizeAlertsInteractor implements VisualizeAlertsUseCase {
    private final AlertRepository alertRepository;
    private final ObjectMapper objectMapper;
    @Override
    public void execute(Integer userId, VisualizeAlertsResponder responder) {
        List<Alert> alerts = alertRepository.getAlertsByUserId(userId);
        VisualizeAlertsResponse response = new VisualizeAlertsResponse(
                alerts.stream().map(alert -> {
                    UserAlertResponse uar = objectMapper.convertValue(alert, UserAlertResponse.class);
                    uar.setAccepted(alert.getUsersNotified().get(0).getAccepted());
                    return uar;
                }).toList()
        );
        responder.onAccept(response);
    }
}
