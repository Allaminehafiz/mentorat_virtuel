package com.mentorat_virtuel.projet_mentorat_virtuel.dto.categorie;

import java.util.Date;

public record CategorieRespDTO(
        String nom,
        String description,
        Boolean status,
        Date dateCreation,
        Date dateModification
) {
}
