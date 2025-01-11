package com.mentorat_virtuel.projet_mentorat_virtuel.dto;

import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.EtatRdv;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.Instant;


public record RDVResDTO(
Instant debutduRDV,
String duree,
String visioconference,
EtatRdv etatRdv
) {
}
