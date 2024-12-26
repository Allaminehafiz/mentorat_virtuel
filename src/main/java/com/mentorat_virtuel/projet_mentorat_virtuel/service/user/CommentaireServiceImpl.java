package com.mentorat_virtuel.projet_mentorat_virtuel.service.user;

import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Commentaire;
import com.mentorat_virtuel.projet_mentorat_virtuel.repositories.CommentaireRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentaireServiceImpl implements CommentaireService{
    private final CommentaireRepo commentaireRepo;

    public CommentaireServiceImpl(CommentaireRepo commentaireRepo) {
        this.commentaireRepo = commentaireRepo;
    }

    @Override
    public Commentaire add(Commentaire commentaire) {
        commentaire.setContent(commentaire.getContent());
        commentaire.setCreatedBy(commentaire.getCreatedBy());
        commentaire.setCreatedAt(new Date());
        return this.commentaireRepo.save(commentaire);
    }

    @Override
    public List<Commentaire> getAllcom() {
        return this.commentaireRepo.findAll();
    }


    @Override
    public Commentaire getById(Integer commentaireId) {
        return null;
    }

    @Override
    public Commentaire updated(Commentaire commentaire, Integer commentaireId) {
        return null;
    }

    @Override
    public void delete(Integer commentaireId) {

    }

}
