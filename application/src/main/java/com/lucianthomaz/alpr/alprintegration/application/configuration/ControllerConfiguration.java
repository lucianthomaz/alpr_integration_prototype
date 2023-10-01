package com.lucianthomaz.alpr.alprintegration.application.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.controller.user.create.UserCreationController;
import com.lucianthomaz.alpr.alprintegration.usecase.user.create.UserCreationUseCase;
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
}
