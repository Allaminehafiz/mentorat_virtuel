package com.mentorat_virtuel.projet_mentorat_virtuel.dto.commentaire;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CommentaireReqDTO {
    @NotEmpty(message = "the field is required")
    private String contenu;
    private Boolean status;
}
