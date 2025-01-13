package com.mentorat_virtuel.projet_mentorat_virtuel.service.commentaire;

import com.mentorat_virtuel.projet_mentorat_virtuel.entity.Commentaire;
import com.mentorat_virtuel.projet_mentorat_virtuel.exception.RessourceNotFoundException;
import com.mentorat_virtuel.projet_mentorat_virtuel.repository.CommentaireRepo;
import com.mentorat_virtuel.projet_mentorat_virtuel.service.commentaire.CommentaireService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentaireServiceImpl implements CommentaireService {
    private final CommentaireRepo commentaireRepo;

    public CommentaireServiceImpl(CommentaireRepo commentaireRepo) {
        this.commentaireRepo = commentaireRepo;
    }

    @Override
    public Commentaire addCommentaire(Commentaire commentaire) {
        return this.commentaireRepo.save(commentaire);
    }

    @Override
    public List<Commentaire> getAllCommentaire() {
        return this.commentaireRepo.findAll();
    }

    @Override
    public Commentaire getCommentaireById(Integer commentaireId) {
        Optional<Commentaire> commentaire = this.commentaireRepo.findById(commentaireId);
        if (commentaire.isEmpty())
            throw new RessourceNotFoundException("the comment with this id doesn't exist");
        return commentaire.get();
    }

    @Override
    public Commentaire editCommentaireStatus(Integer commentaireId) {
        //search
        Commentaire commentaireToEdit = this.commentaireRepo.findById(commentaireId)
                .orElseThrow(()-> new RessourceNotFoundException("comment not found"));
        //modification
        if (commentaireToEdit.getStatus())
            commentaireToEdit.setStatus(false);
        else
            commentaireToEdit.setStatus(true);
        commentaireToEdit.setDateModification(new Date());

        //mise a jour
        return this.commentaireRepo.saveAndFlush(commentaireToEdit);
    }

    @Override
    public Commentaire updateCommentaire(Commentaire commentaire, Integer commentaireId) {

        Commentaire commentaireToEdit = this.commentaireRepo.findById(commentaireId)
                .orElseThrow(()-> new RessourceNotFoundException("Comment not found!!"));

        commentaireToEdit.setContenu(commentaire.getContenu());

        return this.commentaireRepo.saveAndFlush(commentaireToEdit);

    }

    @Override
    public void deleteCommentaire(Integer commentaireId) {
        this.commentaireRepo.delete(this.commentaireRepo.findById(commentaireId)
                .orElseThrow(()-> new RessourceNotFoundException("comment not found!!")));

    }
}
