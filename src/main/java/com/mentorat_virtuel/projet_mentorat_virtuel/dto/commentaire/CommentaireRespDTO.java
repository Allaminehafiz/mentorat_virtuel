package com.mentorat_virtuel.projet_mentorat_virtuel.dto.commentaire;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;

import java.util.Date;

public record CommentaireRespDTO(

        String contenu,
        Boolean status,
        @Temporal(TemporalType.TIME)
        Date dateCreation,
        @Temporal(TemporalType.TIME)
        Date dateModification
) {
}
