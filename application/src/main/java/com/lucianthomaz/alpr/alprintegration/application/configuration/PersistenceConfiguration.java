package com.lucianthomaz.alpr.alprintegration.application.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.persistence.user.UserGateway;
import com.lucianthomaz.alpr.alprintegration.persistence.user.UserJpaRepository;
import com.lucianthomaz.alpr.alprintegration.repositoryInterface.UserRepository;
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
}
