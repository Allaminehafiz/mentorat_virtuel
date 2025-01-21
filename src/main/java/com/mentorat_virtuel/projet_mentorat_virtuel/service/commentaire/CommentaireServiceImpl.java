package com.mentorat_virtuel.projet_mentorat_virtuel.service.commentaire;

import com.mentorat_virtuel.projet_mentorat_virtuel.dto.commentaire.CommentaireReqDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.commentaire.CommentaireRespDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.entity.Commentaire;
import com.mentorat_virtuel.projet_mentorat_virtuel.exception.RessourceNotFoundException;
import com.mentorat_virtuel.projet_mentorat_virtuel.mapper.CommentaireMapper;
import com.mentorat_virtuel.projet_mentorat_virtuel.repository.CommentaireRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentaireServiceImpl implements CommentaireService {
    private final CommentaireRepo commentaireRepo;
    private final CommentaireMapper commentaireMapper;

    public CommentaireServiceImpl(CommentaireRepo commentaireRepo, CommentaireMapper commentaireMapper) {
        this.commentaireRepo = commentaireRepo;
        this.commentaireMapper = commentaireMapper;
    }

    @Override
    public CommentaireRespDTO addCommentaire(CommentaireReqDTO commentaireReqDTO) {
        Commentaire commentaire = this.commentaireMapper.fromCommentaireReqDTO(commentaireReqDTO);
        commentaire = this.commentaireRepo.save(commentaire);
        return commentaireMapper.fromCommentaire(commentaire);
    }

    @Override
    public List<Commentaire> getAllCommentaire() {
        return this.commentaireRepo.findAll();
    }

    @Override
    public Page<CommentaireRespDTO> pagination(int offset, int pageSize) {
        return this.commentaireRepo.findAll(PageRequest.of(offset, pageSize, Sort.by(Sort.Direction.DESC,"dateCreation")))
                .map(commentaire -> this.commentaireMapper.fromCommentaire(commentaire));
    }

    @Override
    public Commentaire getCommentaireById(Integer commentaireId) {
        Optional<Commentaire> commentaire = this.commentaireRepo.findById(commentaireId);
        if (commentaire.isEmpty())
            throw new RessourceNotFoundException("the comment with this id doesn't exist");
        return commentaire.get();
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

    @Override
    public List<Commentaire> addCommentaire(Commentaire commentaire) {
        return this.commentaireRepo.findAll();
    }
}
