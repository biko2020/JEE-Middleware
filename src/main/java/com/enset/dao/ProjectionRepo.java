package com.enset.dao;

import com.enset.entites.Projection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProjectionRepo extends JpaRepository<Projection, Long> {


}
