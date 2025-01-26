package com.mentorat_virtuel.projet_mentorat_virtuel.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RDV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private Date debutduRDV;
    private Date duree;
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

    public Date getDebutduRDV() {
        return debutduRDV;
    }

    public void setDebutduRDV(Date debutduRDV) {
        this.debutduRDV = debutduRDV;
    }

    public Date getDuree() {
        return duree;
    }

    public void setDuree(Date duree) {
        this.duree = duree;
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

}

