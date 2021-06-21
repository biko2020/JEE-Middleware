package com.enset.entites;

import com.enset.dao.CategorieRepo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Sort;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @ToString

public class Categorie implements Serializable {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_categorie;
    @Column(length=85)
    private String name_categorie;
   // @JsonProperty(access = JsonProperty.Access.READ_ONLY)//spécifier la recherche pour spring data REST
    @OneToMany(mappedBy = "categorie")
    private Collection<Film> films;

}
