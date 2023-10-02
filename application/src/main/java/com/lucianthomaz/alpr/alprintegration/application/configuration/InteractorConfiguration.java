package com.lucianthomaz.alpr.alprintegration.application.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.AlertTypeRepository;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.LocationRepository;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.UserRepository;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.VehicleRepository;
import com.lucianthomaz.alpr.alprintegration.interactor.alerttype.AlertTypeCreationInteractor;
import com.lucianthomaz.alpr.alprintegration.interactor.location.LocationCreationInteractor;
import com.lucianthomaz.alpr.alprintegration.interactor.user.UserCreationInteractor;
import com.lucianthomaz.alpr.alprintegration.interactor.vehicle.VehicleCreationInteractor;
import com.lucianthomaz.alpr.alprintegration.usecase.alerttype.create.AlertTypeCreationUseCase;
import com.lucianthomaz.alpr.alprintegration.usecase.location.create.LocationCreationUseCase;
import com.lucianthomaz.alpr.alprintegration.usecase.user.create.UserCreationUseCase;
import com.lucianthomaz.alpr.alprintegration.usecase.vehicle.create.VehicleCreationRequest;
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

}
