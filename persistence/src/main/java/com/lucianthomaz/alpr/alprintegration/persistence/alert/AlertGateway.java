package com.lucianthomaz.alpr.alprintegration.persistence.alert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.domain.Alert;
import com.lucianthomaz.alpr.alprintegration.domain.UserNotification;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.AlertRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class AlertGateway implements AlertRepository {
    private final AlertJpaRepository jpaRepository;
    private final ObjectMapper objectMapper;

    @Override
    public Alert save(Alert alert) {
        PersistentAlert persistentAlert = objectMapper.convertValue(alert, PersistentAlert.class);
        persistentAlert = jpaRepository.save(persistentAlert);
        return objectMapper.convertValue(persistentAlert, Alert.class);
    }

    @Override
    public Optional<Alert> getDetails(int id) {
        Optional<PersistentAlert> persistentAlert = jpaRepository.findById(id);
        return persistentAlert.map(x -> objectMapper.convertValue(x, Alert.class));
    }

    @Override
    public List<Alert> getAlertsByUserId(int userId) {
        List<AlertProjection> persistentAlerts = jpaRepository.findAllByUserId(userId);
        return persistentAlerts.stream().map(pa -> {
            Alert al = objectMapper.convertValue(pa, Alert.class);
            al.setUsersNotified(List.of(UserNotification.builder().name(pa.getName()).email(pa.getEmail())
                    .accepted(toBoolean(pa.getAccepted())).build()));
            return al;
        }).toList();
    }

    public static Boolean toBoolean(Byte b) {
        return b == null ? null : b != 0;
    }
}
