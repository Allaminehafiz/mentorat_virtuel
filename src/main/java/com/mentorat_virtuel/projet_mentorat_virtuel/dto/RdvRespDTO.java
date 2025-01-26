package com.mentorat_virtuel.projet_mentorat_virtuel.dto;

import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.EtatRdv;

import java.util.Date;

public record RdvRespDTO(
        Date debutduRDv,
        Date duree,
        String visioconference,
        EtatRdv etat
) {
}
