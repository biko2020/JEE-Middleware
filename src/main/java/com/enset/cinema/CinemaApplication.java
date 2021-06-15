package com.enset.cinema;

import com.enset.entites.Film;
import com.enset.service.IcinemaInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;


@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.enset.entites"})
@EnableJpaRepositories(basePackages = {"com.enset.dao"})
@ComponentScan(basePackages = {"com.enset.service","com.enset.web"})

public class CinemaApplication implements CommandLineRunner {
    @Autowired
    private IcinemaInitService  icinemaInitService;

    @Autowired
    private RepositoryRestConfiguration restConfiguration;

    public static void main(String[] args) {

        SpringApplication.run(CinemaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        restConfiguration.exposeIdsFor(Film.class);

        icinemaInitService.initVilles();
        icinemaInitService.initCinemas();
        icinemaInitService.initSalles();
        icinemaInitService.initPlaces();
        icinemaInitService.initSeances();
        icinemaInitService.initCategories();
        icinemaInitService.initfilms();
        icinemaInitService.initProjections();
        icinemaInitService.initTickets();
    }
}
