package dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @ToString
public class Categorie {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_categorie;
    private String name_categorie;
    @OneToMany(mappedBy = "categorie")
    private Collection<Film> films;

}
