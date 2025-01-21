package com.mentorat_virtuel.projet_mentorat_virtuel.service.commentaire;

import com.mentorat_virtuel.projet_mentorat_virtuel.dto.commentaire.CommentaireReqDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.commentaire.CommentaireResDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Commentaire;
import com.mentorat_virtuel.projet_mentorat_virtuel.mapper.CommentaireMapper;
import com.mentorat_virtuel.projet_mentorat_virtuel.repositories.CommentaireRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class CommentaireServiceImpl implements CommentaireService {
    private final CommentaireRepo commentaireRepo;
    private final CommentaireMapper commentaireMapper;

    @Autowired
    public CommentaireServiceImpl(CommentaireRepo commentaireRepo, CommentaireMapper commentaireMapper) {
        this.commentaireRepo = commentaireRepo;
        this.commentaireMapper = commentaireMapper;
    }

    @Override
    public CommentaireResDTO add(CommentaireReqDTO commentaireReqDTO) {
        Commentaire commentaire = this.commentaireMapper.fromCommentaireReqDTO(commentaireReqDTO);
        commentaire.setCreatedAt(new Date());
        return this.commentaireMapper.fromCommentaire(this.commentaireRepo.save(commentaire));
    }

    @Override
    public List<Commentaire> getAllcom() {
        return this.commentaireRepo.findAll();
    }


    @Override
    public Commentaire getById(Integer commentaireId) {
        return this.commentaireRepo.findById(commentaireId).get();
    }

    @Override
    public Commentaire updated(Commentaire commentaire, Integer commentaireId) {
        Commentaire commentaire1 = this.commentaireRepo.findById(commentaireId).get();
        if(commentaire.getContent() != null) {
            commentaire1.setContent(commentaire.getContent());
        }
        if(commentaire.getCreatedBy() != null) {
            commentaire1.setCreatedBy(commentaire.getCreatedBy());
        }
        commentaire1.setUpdatedAt(new Date());

        return this.commentaireRepo.saveAndFlush(commentaire1);
    }

    @Override
    public void delete(Integer commentaireId) {
        this.commentaireRepo.deleteById(commentaireId);
    }

}