package com.mentorat_virtuel.projet_mentorat_virtuel.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "ressources")
public class Ressource implements Serializable {
    @Serial
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRessource;
    private String description;
    private Double prix;
    private Date creatAt;
    private Date UpdateAt;
    private Boolean etat;



    /*@OneToMany (mappedBy = "Ressource",
            cascade = CascadeType.ALL,
            fetch = FetchType. EAGER,
            orphanRemoval = true)
    private Set<Category> categories=
            new HashSet<>();*/



}
