package com.mentorat_virtuel.projet_mentorat_virtuel.dto.categorie;

import com.mentorat_virtuel.projet_mentorat_virtuel.dto.post.PostRespDTO;

import java.util.Date;

public record CategorieRespDTO(
        String nom,
        String description,
        Boolean status,
        Date dateCreation,
        Date dateModification,
        PostRespDTO postRespDTO
) {
}
