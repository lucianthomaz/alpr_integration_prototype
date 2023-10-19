package com.lucianthomaz.alpr.alprintegration.usecase.alert.sendtouser;

import com.lucianthomaz.alpr.alprintegration.domain.UserAlert;

import java.util.List;

public interface SendToUserUseCase {
    List<UserAlert> execute(SendToUserRequest request);
}
