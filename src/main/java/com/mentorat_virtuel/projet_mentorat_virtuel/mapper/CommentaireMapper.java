package com.mentorat_virtuel.projet_mentorat_virtuel.mapper;

import com.mentorat_virtuel.projet_mentorat_virtuel.dto.commentaire.CommentaireReqDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.commentaire.CommentaireRespDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.entity.Commentaire;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;

@Mapper(componentModel = "spring")
@Configuration
public interface CommentaireMapper {
    Commentaire fromCommentaireReqDTO(CommentaireReqDTO commentaireReqDTO);
    CommentaireRespDTO fromCommentaire(Commentaire commentaire);
}
