package com.mentorat_virtuel.projet_mentorat_virtuel.service.commentaire;

import com.mentorat_virtuel.projet_mentorat_virtuel.dto.commentaire.CommentaireReqDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.commentaire.CommentaireResDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Commentaire;

import java.util.List;

public interface CommentaireService {
    Commentaire add(Commentaire commentaire);
    List<Commentaire> getAllcom();
    Commentaire getById(Integer commentaireId);
    Commentaire updated(Commentaire commentaire, Integer commentaireId);
    void delete(Integer commentaireId);

}