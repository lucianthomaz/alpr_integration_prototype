package com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface;

import com.lucianthomaz.alpr.alprintegration.domain.Alert;

public interface AlertRepository {
    Alert create(Alert alert);

    Alert getDetails(int id);
}
