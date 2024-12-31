package com.mentorat_virtuel.projet_mentorat_virtuel.controller;

import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Commentaire;
import com.mentorat_virtuel.projet_mentorat_virtuel.service.user.CommentaireService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentaireController {
    private final CommentaireService commentaireService;

    public CommentaireController(CommentaireService commentaireService) {
        this.commentaireService = commentaireService;
    }
    @PostMapping(path = "commentaire/add")
    public ResponseEntity<Commentaire> add(@RequestBody Commentaire commentaire){
        return ResponseEntity.status(200).body(this.commentaireService.add(commentaire));
    }
    @GetMapping( path = "commentaire/getALL")
    public ResponseEntity<List<Commentaire>>  getAllcom(){
        return ResponseEntity.status(201).body(this.commentaireService.getAllcom());
    }

    @GetMapping(path = "commentaire/getbyId{commentaireId}")
    public ResponseEntity<Commentaire> getbyId(@PathVariable Integer commentaireId){
        return ResponseEntity.status(201).body(this.commentaireService.getById(commentaireId));
    }
}
