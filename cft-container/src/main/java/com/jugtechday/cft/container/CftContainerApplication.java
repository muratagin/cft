package com.jugtechday.cft.container;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.jugtechday.cft.infrastructure.persistence"})
@EntityScan(basePackages = {"com.jugtechday.cft.infrastructure.persistence"})
@SpringBootApplication(scanBasePackages = {"com.jugtechday.cft"})
public class CftContainerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CftContainerApplication.class, args);
    }

}
