package com.sprint.otms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages= {"com.sprint.otms.repositories"})
@EntityScan(basePackages = {"com.sprint.otms.models"})
@EnableAutoConfiguration
public class OnlineTripBookingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineTripBookingSystemApplication.class, args);
	}
}
