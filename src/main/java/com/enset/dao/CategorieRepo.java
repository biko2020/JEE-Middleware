package com.enset.dao;

import com.enset.entites.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource
public interface CategorieRepo extends JpaRepository<Categorie, Long> {

}
