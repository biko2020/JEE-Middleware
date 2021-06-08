package com.enset.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @ToString
public class Film implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id_film;
    private String nom_film;
    private String realisateur;
    private Date dateSortie_film;
    private double durre_film;
    private String photo_film;
    @OneToMany(mappedBy = "film")
    private Collection<Projection> projections;
    @ManyToOne()
    private  Categorie categorie;

}
