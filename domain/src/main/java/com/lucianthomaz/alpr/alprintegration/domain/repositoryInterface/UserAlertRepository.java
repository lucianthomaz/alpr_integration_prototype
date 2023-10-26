package com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface;

import com.lucianthomaz.alpr.alprintegration.domain.UserAlert;

import java.util.List;

public interface UserAlertRepository {
    List<UserAlert> sendAlertToUsers(int alertId, List<Integer> usersId);

    UserAlert userAlertAction(int alertId, int userId, boolean accept);
}
