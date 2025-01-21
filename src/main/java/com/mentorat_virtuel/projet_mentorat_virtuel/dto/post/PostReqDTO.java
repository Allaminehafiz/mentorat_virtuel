package com.mentorat_virtuel.projet_mentorat_virtuel.dto.post;

import com.mentorat_virtuel.projet_mentorat_virtuel.dto.commentaire.CommentaireReqDTO;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class PostReqDTO {
    @Length(min = 3,message = "the position name must have at least 3 characters")
    @NotEmpty(message = "the field is required")
    private String nom;
    private String contenu;
    private Boolean status;
    private CommentaireReqDTO commentaireReqDTO;
}
