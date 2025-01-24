package com.mentorat_virtuel.projet_mentorat_virtuel.dto;

import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.EtatRdv;


public record RDVResDTO(
        String debutduRDV,
        String duree,
        EtatRdv visioconference,
        String etatRdv
) {

}
