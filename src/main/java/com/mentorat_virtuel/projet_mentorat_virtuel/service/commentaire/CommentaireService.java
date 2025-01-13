package com.mentorat_virtuel.projet_mentorat_virtuel.service;

import com.mentorat_virtuel.projet_mentorat_virtuel.entity.Commentaire;

import java.util.List;

public interface CommentaireService {

    Commentaire addCommentaire(Commentaire commentaire);
    public List<Commentaire> getAllCommentaire();
    public Commentaire getCommentaireById(Integer commentaireId);
    public Commentaire editCommentaireStatus(Integer commentaireId);
    public Commentaire updateCommentaire(Commentaire commentaire,Integer commentaireId);
    public void deleteCommentaire(Integer commentaireId);
}
