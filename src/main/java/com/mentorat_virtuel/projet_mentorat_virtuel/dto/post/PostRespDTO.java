package com.mentorat_virtuel.projet_mentorat_virtuel.dto.post;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public record PostRespDTO(
         String nom,
         String contenu,
         Boolean status,
        @Temporal(TemporalType.TIME)
         Date dateCreation,
        @DateTimeFormat(pattern = "yyyy-mm-dd")
         Date dateModification
) {
}
