package com.mentorat_virtuel.projet_mentorat_virtuel.Entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity
public class RDV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private Instant debutduRDV;
    private String duree;
    private String visioconference;
    @Enumerated(EnumType.STRING)
    private EtatRdv etat;

    //association
    @OneToOne
    private Thematique thematique;
    @OneToOne
    private Mentoret mentoret;
    @OneToOne
    private Mentor mentor;
    @OneToMany(mappedBy = "rdv")
    private List<FeedBack> feedback = new ArrayList<>();

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Instant getDebutduRDV() {
        return debutduRDV;
    }

    public void setDebutduRDV(Instant debutduRDV) {
        this.debutduRDV = debutduRDV;
    }

    public String getVisioconference() {
        return visioconference;
    }

    public void setVisioconference(String visioconference) {
        this.visioconference = visioconference;
    }

    public EtatRdv getEtat() {
        return etat;
    }

    public void setEtat(EtatRdv etat) {
        this.etat = etat;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public Object getMentor() {
        return mentor;

    }
}

