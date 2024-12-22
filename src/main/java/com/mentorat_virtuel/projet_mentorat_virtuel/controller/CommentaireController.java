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
    @GetMapping(path = "commentaire/getAll")
    public ResponseEntity<List<Commentaire>> getAll(){
        return ResponseEntity.status(201).body(this.commentaireService.getAll());
    }
    @GetMapping(path = "commentaire/getById{commentaireId}")
    public ResponseEntity<Commentaire> getbyid(@PathVariable Integer commentaireId){
        return  ResponseEntity.status(201).body(this.commentaireService.getById(commentaireId));
    }
    @PutMapping(path = "commentaire/update{commentaireId}")
    public ResponseEntity<Commentaire> update(@RequestBody Commentaire commentaire, @PathVariable Integer commentaireId){
        return ResponseEntity.status(201).body(this.commentaireService.updated(commentaire, commentaireId));
    }

    @DeleteMapping(path = "commentaire/delete{commentaireId}")
    public ResponseEntity<String> delete(@PathVariable Integer commentaireId){
        this.commentaireService.delete(commentaireId);
        return ResponseEntity.status(202).body("Deleted !!!");
    }
}
