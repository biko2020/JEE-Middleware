package com.enset.dao;

import com.enset.entites.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PlaceRepo extends JpaRepository<Place,Long> {




}
