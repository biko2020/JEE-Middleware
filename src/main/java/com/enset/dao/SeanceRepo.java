package com.enset.dao;

import com.enset.entites.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SeanceRepo extends JpaRepository<Seance, Long> {



}
