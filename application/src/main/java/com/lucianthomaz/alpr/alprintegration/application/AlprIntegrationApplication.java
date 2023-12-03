package com.lucianthomaz.alpr.alprintegration.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AlprIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlprIntegrationApplication.class, args);
	}

}
