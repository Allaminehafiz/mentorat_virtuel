package com.mentorat_virtuel.projet_mentorat_virtuel.Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table
@Entity
public class RDV {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Temporal(TemporalType.TIME)
    private Date debutduRDV;
    @Temporal(TemporalType.TIME)
    private Date duree;
    private String visioconference;
    private Boolean etat;
   // private Integer mentorId;
    //private Integer mentoretId;

//association
@OneToOne
    private Thematique thematique;
@OneToOne
    private Mentoret mentoret;
@OneToOne
    private Mentor mentor;
@OneToMany(mappedBy ="rdv" )
    private List<FeedBack> feedback =new ArrayList<>();


}
