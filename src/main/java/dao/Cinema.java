package dao;

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
@Id @GeneratedValue(strategy = GenerationType.AUTO.IDENTITY)
    private Long id;
    private String namecinema;
    private double longitude,latitide, altitude;
    private int nbrsalle;

@OneToMany(mappedBy = "")
    private Collection<Salle> salles;

}
