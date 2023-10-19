package com.lucianthomaz.alpr.alprintegration.application.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.*;
import com.lucianthomaz.alpr.alprintegration.persistence.alert.AlertGateway;
import com.lucianthomaz.alpr.alprintegration.persistence.alert.AlertJpaRepository;
import com.lucianthomaz.alpr.alprintegration.persistence.alerttype.AlertTypeGateway;
import com.lucianthomaz.alpr.alprintegration.persistence.alerttype.AlertTypeJpaRepository;
import com.lucianthomaz.alpr.alprintegration.persistence.location.LocationGateway;
import com.lucianthomaz.alpr.alprintegration.persistence.location.LocationJpaRepository;
import com.lucianthomaz.alpr.alprintegration.persistence.user.UserGateway;
import com.lucianthomaz.alpr.alprintegration.persistence.user.UserJpaRepository;
import com.lucianthomaz.alpr.alprintegration.persistence.useralert.UserAlertGateway;
import com.lucianthomaz.alpr.alprintegration.persistence.useralert.UserAlertJpaRepository;
import com.lucianthomaz.alpr.alprintegration.persistence.vehicle.VehicleGateway;
import com.lucianthomaz.alpr.alprintegration.persistence.vehicle.VehicleJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.lucianthomaz.alpr.alprintegration.persistence")
@EntityScan(basePackages = "com.lucianthomaz.alpr.alprintegration.persistence")
public class PersistenceConfiguration {

    @Bean
    @Autowired
    public UserRepository userRepository(UserJpaRepository userJpaRepository, ObjectMapper objectMapper) {
        return new UserGateway(userJpaRepository, objectMapper);
    }

    @Bean
    @Autowired
    public AlertTypeRepository alertTypeRepository(AlertTypeJpaRepository alertTypeJpaRepository, ObjectMapper objectMapper) {
        return new AlertTypeGateway(alertTypeJpaRepository, objectMapper);
    }

    @Bean
    @Autowired
    public VehicleRepository vehicleRepository(VehicleJpaRepository jpaRepository, ObjectMapper objectMapper) {
        return new VehicleGateway(jpaRepository, objectMapper);
    }

    @Bean
    @Autowired
    public LocationRepository locationRepository(LocationJpaRepository jpaRepository, ObjectMapper objectMapper) {
        return new LocationGateway(jpaRepository, objectMapper);
    }

    @Bean
    @Autowired
    public UserAlertRepository userAlertRepository(UserAlertJpaRepository jpaRepository, ObjectMapper objectMapper) {
        return new UserAlertGateway(jpaRepository, objectMapper);
    }

    @Bean
    @Autowired
    public AlertRepository alertRepository(AlertJpaRepository jpaRepository, ObjectMapper objectMapper) {
        return new AlertGateway(jpaRepository, objectMapper);
    }
}
