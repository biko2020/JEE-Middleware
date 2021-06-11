package com.enset.dao;

import com.enset.entites.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")// autoriser a d autres domaines de communiquer avec cette application
public interface VilleRepo extends JpaRepository<Ville, Long> {

}
