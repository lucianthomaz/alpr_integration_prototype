package com.lucianthomaz.alpr.alprintegration.application.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.UserRepository;
import com.lucianthomaz.alpr.alprintegration.interactor.user.UserCreationInteractor;
import com.lucianthomaz.alpr.alprintegration.usecase.user.create.UserCreationUseCase;
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

}
