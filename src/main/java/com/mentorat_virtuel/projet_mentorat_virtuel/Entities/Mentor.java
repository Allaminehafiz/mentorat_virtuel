package com.mentorat_virtuel.projet_mentorat_virtuel.Entities;

import jakarta.persistence.*;

@Table
@Entity
public class Mentor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String firstname;
    private String lastname;
    //association
    @OneToOne
    private RDV rdv;
}
