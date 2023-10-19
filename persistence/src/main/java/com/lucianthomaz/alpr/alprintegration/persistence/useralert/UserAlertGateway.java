package com.lucianthomaz.alpr.alprintegration.persistence.useralert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.domain.UserAlert;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.UserAlertRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class UserAlertGateway implements UserAlertRepository {
    private final UserAlertJpaRepository jpaRepository;
    private final ObjectMapper objectMapper;

    @Override
    public List<UserAlert> sendAlertToUsers(int alertId, List<Integer> usersId) {
        List<PersistentUserAlert> persistentUserAlerts = usersId.stream().map(x -> new PersistentUserAlert(alertId, x, null)).toList();
        persistentUserAlerts = jpaRepository.saveAll(persistentUserAlerts);
        return persistentUserAlerts.stream().map(x -> objectMapper.convertValue(x, UserAlert.class)).toList();
    }
}
