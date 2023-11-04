package com.lucianthomaz.alpr.alprintegration.interactor.alert.getalertsbyuser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.domain.Alert;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.AlertRepository;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.shared.UserAlertResponse;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.getalertsbyuser.GetAlertsByUserResponder;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.getalertsbyuser.GetAlertsByUserResponse;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.getalertsbyuser.GetAlertsByUserUseCase;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class GetAlertsByUserInteractor implements GetAlertsByUserUseCase {
    private final AlertRepository alertRepository;
    private final ObjectMapper objectMapper;
    @Override
    public void execute(Integer userId, GetAlertsByUserResponder responder) {
        List<Alert> alerts = alertRepository.getAlertsByUserId(userId);
        GetAlertsByUserResponse response = new GetAlertsByUserResponse(
                alerts.stream().map(alert -> {
                    UserAlertResponse uar = objectMapper.convertValue(alert, UserAlertResponse.class);
                    uar.setAccepted(alert.getUsersNotified().get(0).getAccepted());
                    return uar;
                }).toList()
        );
        responder.onAccept(response);
    }
}
