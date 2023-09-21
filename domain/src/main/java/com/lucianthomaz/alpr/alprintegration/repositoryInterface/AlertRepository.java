package com.lucianthomaz.alpr.alprintegration.repositoryInterface;

import com.lucianthomaz.alpr.alprintegration.Alert;

public interface AlertRepository {
    Alert create(Alert alert);

    Alert getDetails(int id);
}
