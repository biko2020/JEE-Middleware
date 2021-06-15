package com.enset.entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Salle implements Serializable {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_salle;
    @Column(length=30)
    private String name_salle;
    private int nbr_place;

    @ManyToOne()
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Cinema cinema;
    @OneToMany(mappedBy = "salle")
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Place> places;
    @OneToMany
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Projection> projections;

}
