package com.mentorat_virtuel.projet_mentorat_virtuel.service.commentaire;

import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Commentaire;
import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Sujet;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CommentaireService {
    Commentaire add(Commentaire commentaire);
    Page<Commentaire> getComment(int offset, int pageSize);
    List<Commentaire> getAllcom();
    Commentaire getById(Integer commentaireId);
    Commentaire updated(Commentaire commentaire, Integer commentaireId);
    void delete(Integer commentaireId);

}