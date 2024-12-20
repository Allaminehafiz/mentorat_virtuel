package com.mentorat_virtuel.projet_mentorat_virtuel.Entities;

import jakarta.persistence.*;

@Table
@Entity
public class Thematique {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String libelle;
    //association
    @OneToOne
    private RDV rdv;
}
