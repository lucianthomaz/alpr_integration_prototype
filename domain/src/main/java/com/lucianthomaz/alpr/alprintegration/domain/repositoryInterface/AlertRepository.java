package com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface;

import com.lucianthomaz.alpr.alprintegration.domain.Alert;

import java.util.List;

public interface AlertRepository {
    Alert create(Alert alert);

    Alert getDetails(int id);

    List<Alert> getAlertsByUserId(int userId);
}
