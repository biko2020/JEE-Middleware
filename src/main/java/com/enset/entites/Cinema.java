package com.enset.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Cinema implements Serializable {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cinema;
    @Column(length=45)
    private String name_cinema;
    private double longitude_cin,latitide_cin, altitude_cin;
    private int nbr_salle;
    private  int code_Ville;

@OneToMany(mappedBy = "cinema")
    private Collection<Salle> salles;


}
