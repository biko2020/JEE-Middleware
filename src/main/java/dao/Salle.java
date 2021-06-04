package dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Salle {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_salle;
    private String name_salle;
    private int nbr_place;

    @ManyToOne()
    private Cinema cinema;
}
