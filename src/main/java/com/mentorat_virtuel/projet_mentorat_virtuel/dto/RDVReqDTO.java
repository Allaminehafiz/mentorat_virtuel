package com.mentorat_virtuel.projet_mentorat_virtuel.dto;

import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.EtatRdv;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.Instant;

@Data
public class RDVReqDTO {
    private Instant debutduRDV;
    private String duree;
    private String visioconference;
    @Enumerated(EnumType.STRING)
    private EtatRdv etat;
}
