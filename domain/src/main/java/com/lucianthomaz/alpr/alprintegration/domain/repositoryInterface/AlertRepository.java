package com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface;

import com.lucianthomaz.alpr.alprintegration.domain.Alert;

import java.util.List;
import java.util.Optional;

public interface AlertRepository {
    Alert save(Alert alert);

    Optional<Alert> getDetails(int id);

    List<Alert> getAlertsByUserId(int userId);

}
