package dao;

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
@NoArgsConstructor @AllArgsConstructor @ToString
public class Projection implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_projection;
    private Date dat_projection;
    private  double prix_projection;
    @ManyToOne
    private Salle salle;
    @ManyToOne
    private  Film film;
    @OneToMany(mappedBy="projection")
    private Collection<Ticket> tickets;
    @ManyToOne
    private Seance seance;


}
