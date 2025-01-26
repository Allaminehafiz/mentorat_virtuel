package com.mentorat_virtuel.projet_mentorat_virtuel.dto;

import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.EtatRdv;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.Date;
@Data
public class RdvReqDTO {
    private Date debutduRDV;
    private Date duree;
    private String visioconference;
    @Enumerated(EnumType.STRING)
    private EtatRdv etat;

    public Date getDebutduRDV() {
        return debutduRDV;
    }

    public void setDebutduRDV(Date debutduRDV) {
        this.debutduRDV = debutduRDV;
    }

    public String getVisioconference() {
        return visioconference;
    }

    public void setVisioconference(String visioconference) {
        this.visioconference = visioconference;
    }

    public Date getDuree() {
        return duree;
    }

    public void setDuree(Date duree) {
        this.duree = duree;
    }

    public EtatRdv getEtat() {
        return etat;
    }

    public void setEtat(EtatRdv etat) {
        this.etat = etat;
    }
}
