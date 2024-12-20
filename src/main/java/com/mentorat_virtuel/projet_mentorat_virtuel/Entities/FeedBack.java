package com.mentorat_virtuel.projet_mentorat_virtuel.Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table
@Entity
public class FeedBack {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer feedbackId;
    private Integer note;
    private String commentaire;
   // private Integer rdvId;
    //private Integer mentoretId;
    //association
    @ManyToOne
    private RDV rdv;
}
