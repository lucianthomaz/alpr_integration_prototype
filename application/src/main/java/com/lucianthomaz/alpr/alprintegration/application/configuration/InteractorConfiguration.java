package com.lucianthomaz.alpr.alprintegration.application.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.*;
import com.lucianthomaz.alpr.alprintegration.interactor.alert.complete.AlertCompletionInteractor;
import com.lucianthomaz.alpr.alprintegration.interactor.alert.create.AlertCreationInteractor;
import com.lucianthomaz.alpr.alprintegration.interactor.alert.create.SendToUserInteractor;
import com.lucianthomaz.alpr.alprintegration.interactor.alert.monitor.NotificationMonitor;
import com.lucianthomaz.alpr.alprintegration.interactor.alert.useralertaction.UserAlertActionInteractor;
import com.lucianthomaz.alpr.alprintegration.interactor.alert.getalertsbyuser.GetAlertsByUserInteractor;
import com.lucianthomaz.alpr.alprintegration.interactor.alerttype.AlertTypeCreationInteractor;
import com.lucianthomaz.alpr.alprintegration.interactor.location.LocationCreationInteractor;
import com.lucianthomaz.alpr.alprintegration.interactor.user.UserCreationInteractor;
import com.lucianthomaz.alpr.alprintegration.interactor.vehicle.VehicleCreationInteractor;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.complete.AlertCompletionUseCase;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.create.AlertCreationUseCase;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.sendtouser.SendToUserUseCase;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.useralertaction.UserAlertActionUseCase;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.getalertsbyuser.GetAlertsByUserUseCase;
import com.lucianthomaz.alpr.alprintegration.usecase.alerttype.create.AlertTypeCreationUseCase;
import com.lucianthomaz.alpr.alprintegration.usecase.location.create.LocationCreationUseCase;
import com.lucianthomaz.alpr.alprintegration.usecase.user.create.UserCreationUseCase;
import com.lucianthomaz.alpr.alprintegration.usecase.vehicle.create.VehicleCreationUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InteractorConfiguration {

    @Bean
    @Autowired
    UserCreationUseCase userCreationUseCase(UserRepository userRepository, ObjectMapper objectMapper) {
        return new UserCreationInteractor(userRepository, objectMapper);
    }

    @Bean
    @Autowired
    AlertTypeCreationUseCase alertTypeCreationUseCase(AlertTypeRepository alertTypeRepository, ObjectMapper objectMapper) {
        return new AlertTypeCreationInteractor(alertTypeRepository, objectMapper);
    }

    @Bean
    @Autowired
    VehicleCreationUseCase vehicleCreationUseCase(VehicleRepository vehicleRepository, ObjectMapper objectMapper) {
        return new VehicleCreationInteractor(vehicleRepository, objectMapper);
    }

    @Bean
    @Autowired
    LocationCreationUseCase locationCreationUseCase(LocationRepository locationRepository, ObjectMapper objectMapper) {
        return new LocationCreationInteractor(locationRepository, objectMapper);
    }

    @Bean
    @Autowired
    SendToUserUseCase sendToUserUseCase(UserAlertRepository userAlertRepository,
                                        AlertRepository alertRepository,
                                        LocationRepository locationRepository,
                                        UserRepository userRepository) {
        return new SendToUserInteractor(userAlertRepository, alertRepository, locationRepository, userRepository);
    }

    @Bean
    @Autowired
    AlertCreationUseCase alertCreationUseCase(AlertRepository alertRepository, ObjectMapper objectMapper,
                                              UserRepository userRepository) {
        return new AlertCreationInteractor(alertRepository, objectMapper, userRepository);
    }

    @Bean
    @Autowired
    GetAlertsByUserUseCase getAlertsByUserUseCase(AlertRepository alertRepository, ObjectMapper objectMapper) {
        return new GetAlertsByUserInteractor(alertRepository, objectMapper);
    }

    @Bean
    @Autowired
    UserAlertActionUseCase userAlertActionUseCase(UserAlertRepository userAlertRepository, AlertRepository alertRepository, ObjectMapper objectMapper) {
        return new UserAlertActionInteractor(userAlertRepository, alertRepository, objectMapper);
    }

    @Bean
    @Autowired
    AlertCompletionUseCase alertCompletionUseCase(AlertRepository alertRepository, ObjectMapper objectMapper) {
        return new AlertCompletionInteractor(alertRepository, objectMapper);
    }

    @Bean
    NotificationMonitor notificationMonitor(AlertRepository alertRepository, SendToUserUseCase sendToUserUseCase) {
        return new NotificationMonitor(alertRepository, sendToUserUseCase);
    }

}
