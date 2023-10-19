package com.lucianthomaz.alpr.alprintegration.interactor.alert;

import com.lucianthomaz.alpr.alprintegration.domain.UserAlert;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.UserAlertRepository;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.sendtouser.SendToUserRequest;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.sendtouser.SendToUserUseCase;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class SendToUserInteractor implements SendToUserUseCase {

    private final UserAlertRepository repository;

    @Override
    public List<UserAlert> execute(SendToUserRequest request) {
        return repository.sendAlertToUsers(request.alertId(), request.usersId());
    }
}
