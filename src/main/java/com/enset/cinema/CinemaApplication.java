package com.enset.cinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.enset.entites"})
@EnableJpaRepositories(basePackages = "com.enset.dao")

public class CinemaApplication {

    public static void main(String[] args) {

        SpringApplication.run(CinemaApplication.class, args);
    }

}
