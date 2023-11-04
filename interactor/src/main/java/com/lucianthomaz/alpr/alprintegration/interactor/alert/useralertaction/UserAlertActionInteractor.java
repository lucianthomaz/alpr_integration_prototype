package com.lucianthomaz.alpr.alprintegration.interactor.alert.useralertaction;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.domain.Alert;
import com.lucianthomaz.alpr.alprintegration.domain.StatusEnum;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.AlertRepository;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.UserAlertRepository;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.shared.UserAlertResponse;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.useralertaction.UserAlertActionRequest;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.useralertaction.UserAlertActionResponder;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.useralertaction.UserAlertActionUseCase;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

@AllArgsConstructor
public class UserAlertActionInteractor implements UserAlertActionUseCase {
    private final UserAlertRepository userAlertRepository;
    private final AlertRepository alertRepository;
    private final ObjectMapper objectMapper;

    @Override
    public void execute(UserAlertActionRequest request, UserAlertActionResponder responder) {
        userAlertRepository.userAlertAction(request.alertId(), request.userId(), request.accepted());
        Optional<Alert> alert = alertRepository.getDetails(request.alertId());
        if (request.accepted()) {
            if (alert.isPresent()) {
                Alert a = alert.get();
                a.setStatus(StatusEnum.ACCEPTED.name());
                a.setLastModified(LocalDateTime.now());
                a.setLastModifiedBy(request.userId());
                alertRepository.save(a);
            }

        }
        UserAlertResponse response = alert.map(x -> {
            UserAlertResponse alertResponse = objectMapper.convertValue(x, UserAlertResponse.class);
            alertResponse.setAccepted(request.accepted());
            return alertResponse;
        }).get();
        responder.onAccept(response);
    }
}
