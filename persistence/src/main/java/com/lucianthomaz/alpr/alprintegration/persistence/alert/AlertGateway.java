package com.lucianthomaz.alpr.alprintegration.persistence.alert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.domain.Alert;
import com.lucianthomaz.alpr.alprintegration.domain.UserNotification;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.AlertRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class AlertGateway implements AlertRepository {
    private final AlertJpaRepository jpaRepository;
    private final ObjectMapper objectMapper;

    @Override
    public Alert create(Alert alert) {
        PersistentAlert persistentAlert = objectMapper.convertValue(alert, PersistentAlert.class);
        persistentAlert = jpaRepository.save(persistentAlert);
        return objectMapper.convertValue(persistentAlert, Alert.class);
    }

    @Override
    public Alert getDetails(int id) {
        return null;
    }

    @Override
    public List<Alert> getAlertsByUserId(int userId) {
        List<PersistentAlertWithUsersAcceptance> persistentAlerts = jpaRepository.findAllByUserId(userId);
        return persistentAlerts.stream().map(pa -> {
            Alert al = objectMapper.convertValue(pa, Alert.class);
            al.setUsersNotified(List.of(UserNotification.builder().name(pa.getName()).email(pa.getEmail())
                    .accepted(pa.getAccepted()).build()));
            return al;
        }).toList();
    }
}
