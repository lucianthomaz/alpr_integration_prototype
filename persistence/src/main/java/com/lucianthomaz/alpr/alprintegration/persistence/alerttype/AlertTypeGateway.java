package com.lucianthomaz.alpr.alprintegration.persistence.alerttype;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.domain.AlertType;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.AlertTypeRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AlertTypeGateway implements AlertTypeRepository {
    private final AlertTypeJpaRepository jpaRepository;
    private final ObjectMapper objectMapper;

    @Override
    public AlertType create(AlertType alertType) {
        PersistentAlertType persistentAlertType = objectMapper.convertValue(alertType, PersistentAlertType.class);
        return objectMapper.convertValue(jpaRepository.save(persistentAlertType), AlertType.class);
    }

    @Override
    public AlertType getAlertType(int id) {
        PersistentAlertType persistentAlertType = jpaRepository.getReferenceById(id);
        return objectMapper.convertValue(persistentAlertType, AlertType.class);
    }
}
