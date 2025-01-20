package com.mentorat_virtuel.projet_mentorat_virtuel.mapper;


import com.mentorat_virtuel.projet_mentorat_virtuel.dto.commentaire.CommentaireReqDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.commentaire.CommentaireResDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Commentaire;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;

@Mapper(componentModel = "spring")
@Configuration
public interface CommentaireMapper {
    Commentaire fromCommentaireReqDTO(CommentaireReqDTO commentaireReqDTO);
    CommentaireResDTO fromCommentaire(Commentaire commentaire);
}
