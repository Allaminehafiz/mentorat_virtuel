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
}
