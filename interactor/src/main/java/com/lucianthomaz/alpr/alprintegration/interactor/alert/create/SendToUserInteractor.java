package com.lucianthomaz.alpr.alprintegration.interactor.alert.create;

import com.lucianthomaz.alpr.alprintegration.domain.Alert;
import com.lucianthomaz.alpr.alprintegration.domain.StatusEnum;
import com.lucianthomaz.alpr.alprintegration.domain.UserAlert;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.AlertRepository;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.UserAlertRepository;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.sendtouser.SendToUserRequest;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.sendtouser.SendToUserUseCase;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class SendToUserInteractor implements SendToUserUseCase {

    private final UserAlertRepository repository;
    private final AlertRepository alertRepository;

    @Override
    public List<UserAlert> execute(SendToUserRequest request) {
        Optional<Alert> alert = alertRepository.getDetails(request.alertId());
        alert.ifPresent(x -> {
            x.setStatus(StatusEnum.USERS_NOTIFIED.name());
            alertRepository.save(x);
        });
        return repository.sendAlertToUsers(request.alertId(), request.usersId());
    }
}
