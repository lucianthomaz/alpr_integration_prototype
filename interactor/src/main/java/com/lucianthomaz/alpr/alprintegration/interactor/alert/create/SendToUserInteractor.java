package com.lucianthomaz.alpr.alprintegration.interactor.alert.create;

import com.lucianthomaz.alpr.alprintegration.domain.*;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.AlertRepository;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.LocationRepository;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.UserAlertRepository;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.UserRepository;
import com.lucianthomaz.alpr.alprintegration.interactor.alert.shared.LocationUtils;
import com.lucianthomaz.alpr.alprintegration.interactor.alert.shared.NotificationService;
import com.lucianthomaz.alpr.alprintegration.interactor.alert.shared.UserLocation;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.sendtouser.SendToUserRequest;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.sendtouser.SendToUserUseCase;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class SendToUserInteractor implements SendToUserUseCase {
    private static final int SYSTEM = 1;

    private final UserAlertRepository repository;
    private final AlertRepository alertRepository;
    private final LocationRepository locationRepository;
    private final UserRepository userRepository;

    @Override
    public List<UserAlert> execute(SendToUserRequest request) {
        Optional<Alert> optionalAlert = alertRepository.getDetails(request.alertId());
        if (optionalAlert.isPresent()){
            Alert alert = optionalAlert.get();

            Location location = locationRepository.getLocation(alert.getLocationId()).get();
            List<User> usersWithUpdatedLocation = userRepository.getUsersWithUpdatedLocation();
            List<UserLocation> usersLocation = usersWithUpdatedLocation.stream()
                    .map(user -> new UserLocation(user.getId(), user.getLastKnownLatitude(), user.getLastKnownLongitude()))
                    .toList();

            Optional<User> optionalUser = usersWithUpdatedLocation.stream().filter(user ->
                    user.getId() == LocationUtils.findClosestLocation(location, usersLocation).userId()).findFirst();

            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                String data = """
                        {"message": "Um veículo em situação irregular acabou de ser detectado no local abaixo, e você é o policial mais próximo dele!",
                        \t"latitude": "%f",
                        \t"longitude": "%f",
                        \t"address": "%s",
                        \t"direction": "%s",
                        \t"details": "%s",
                        \t"alertId": "%d",
                        \t"userId": "%d"
                        }""".formatted(location.getLatitude(),
                        location.getLongitude(),
                        location.getAddress(),
                        location.getDirection(),
                        alert.getDetails(),
                        alert.getId(),
                        user.getId());

                NotificationService.sendPushNotificationWithData(
                        user.getDeviceFcmToken(),
                        "Irregular vehicle alert",
                        "You are close to a detected irregular vehicle",
                        data);

                List<UserAlert> usersNotified = repository.sendAlertToUsers(request.alertId(), List.of(user.getId()));

                alert.setStatus(StatusEnum.USERS_NOTIFIED.name());
                alert.setLastModified(LocalDateTime.now());
                alert.setLastModifiedBy(SYSTEM);
                alertRepository.save(alert);
                return usersNotified;
            }

        }
        return new ArrayList<>();
    }
}
