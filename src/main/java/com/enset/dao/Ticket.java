package com.enset.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @ToString
public class Ticket implements Serializable {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_ticket;
    private String nom_client;
    private double prix_ticket;
    private int codepayment_ticket;
    private int reserve;
    @ManyToOne
    private Place place;
    @ManyToOne
    private Projection projection;

}
