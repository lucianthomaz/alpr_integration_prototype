package com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface;

import com.lucianthomaz.alpr.alprintegration.domain.AlertType;

public interface AlertTypeRepository {

    AlertType create(AlertType alertType);

    AlertType getAlertType(int id);
}
