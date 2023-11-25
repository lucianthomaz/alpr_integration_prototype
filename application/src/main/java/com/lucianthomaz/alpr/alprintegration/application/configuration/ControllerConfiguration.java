package com.lucianthomaz.alpr.alprintegration.application.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.controller.alert.complete.AlertCompletionController;
import com.lucianthomaz.alpr.alprintegration.controller.alert.create.AlertCreationController;
import com.lucianthomaz.alpr.alprintegration.controller.alert.useralertaction.UserAlertActionController;
import com.lucianthomaz.alpr.alprintegration.controller.alert.getalertsbyuser.GetAlertsByUserController;
import com.lucianthomaz.alpr.alprintegration.controller.alerttype.create.AlertTypeCreationController;
import com.lucianthomaz.alpr.alprintegration.controller.location.create.LocationCreationController;
import com.lucianthomaz.alpr.alprintegration.controller.user.create.UserCreationController;
import com.lucianthomaz.alpr.alprintegration.controller.user.location.UserUpdateLocationController;
import com.lucianthomaz.alpr.alprintegration.controller.user.login.UserLoginController;
import com.lucianthomaz.alpr.alprintegration.controller.user.updatefcmtoken.UpdateDeviceFcmTokenController;
import com.lucianthomaz.alpr.alprintegration.controller.vehicle.create.VehicleCreationController;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.UserRepository;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.complete.AlertCompletionUseCase;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.create.AlertCreationUseCase;
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
public class ControllerConfiguration {
    @Bean
    @Autowired
    UserCreationController userCreationController(UserCreationUseCase userCreationUseCase, ObjectMapper objectMapper) {
        return new UserCreationController(userCreationUseCase, objectMapper);
    }

    @Bean
    @Autowired
    AlertTypeCreationController alertTypeCreationController(AlertTypeCreationUseCase useCase, ObjectMapper objectMapper) {
        return new AlertTypeCreationController(useCase, objectMapper);
    }

    @Bean
    @Autowired
    VehicleCreationController vehicleCreationController(VehicleCreationUseCase useCase, ObjectMapper objectMapper) {
        return new VehicleCreationController(useCase, objectMapper);
    }

    @Bean
    @Autowired
    LocationCreationController locationCreationController(LocationCreationUseCase useCase, ObjectMapper objectMapper) {
        return new LocationCreationController(useCase, objectMapper);
    }

    @Bean
    @Autowired
    AlertCreationController alertCreationController(AlertCreationUseCase useCase, ObjectMapper objectMapper) {
        return new AlertCreationController(useCase, objectMapper);
    }

    @Bean
    @Autowired
    GetAlertsByUserController getAlertsByUserController(GetAlertsByUserUseCase useCase, ObjectMapper objectMapper) {
        return new GetAlertsByUserController(useCase, objectMapper);
    }

    @Bean
    @Autowired
    UserAlertActionController userAlertActionController(UserAlertActionUseCase useCase, ObjectMapper objectMapper) {
        return new UserAlertActionController(useCase, objectMapper);
    }

    @Bean
    @Autowired
    AlertCompletionController alertCompletionController(AlertCompletionUseCase useCase, ObjectMapper objectMapper) {
        return new AlertCompletionController(useCase, objectMapper);
    }

    @Bean
    UserUpdateLocationController userUpdateLocationController() {
        return new UserUpdateLocationController();
    }

    @Bean
    UpdateDeviceFcmTokenController updateDeviceFcmTokenController(UserRepository userRepository) {
        return new UpdateDeviceFcmTokenController(userRepository);
    }
    @Bean
    UserLoginController userLoginController(UserRepository userRepository) {
        return new UserLoginController(userRepository);
    }
}
