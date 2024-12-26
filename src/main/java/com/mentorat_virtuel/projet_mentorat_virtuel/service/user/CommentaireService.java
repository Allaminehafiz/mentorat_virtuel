package com.mentorat_virtuel.projet_mentorat_virtuel.service.user;

import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Commentaire;
import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Sujet;

import java.util.List;

public interface CommentaireService {
    Commentaire add(Commentaire commentaire);
    List<Commentaire> getAllcom();
    Commentaire getById(Integer commentaireId);
    Commentaire updated(Commentaire commentaire, Integer commentaireId);
    void delete(Integer commentaireId);

}
