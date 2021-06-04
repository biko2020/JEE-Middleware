package dao;

import javax.persistence.*;

@Entity
public class Place {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_place;
    private int num_salle;
    private double longitude_plce,latitide_plce, altitude_plce;
    @ManyToOne
    private  Salle salle;
}
