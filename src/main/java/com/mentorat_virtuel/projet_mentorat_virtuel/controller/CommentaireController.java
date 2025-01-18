package com.mentorat_virtuel.projet_mentorat_virtuel.controller;

import com.mentorat_virtuel.projet_mentorat_virtuel.dto.commentaire.CommentaireReqDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.commentaire.CommentaireRespDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.entity.Commentaire;
import com.mentorat_virtuel.projet_mentorat_virtuel.service.commentaire.CommentaireService;
import org.springframework.http.HttpStatus;
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
    @ResponseBody
    public ResponseEntity<CommentaireRespDTO> addCommentaire(@RequestBody CommentaireReqDTO commentaireReqDTO){

        CommentaireRespDTO commentaireRespDTO = this.commentaireService.addCommentaire(commentaireReqDTO);
        return new ResponseEntity<>(commentaireRespDTO,HttpStatus.CREATED);
    }
    @GetMapping(path = "commentaire/get_all_commentaire")
    public ResponseEntity<List<Commentaire>> getAllCommentaire(){
        return ResponseEntity
                .ok(this.commentaireService.getAllCommentaire());
    }
    @GetMapping(path = "commentaire/get_commentaire_by_id/{commentaireId}")
    public ResponseEntity<Commentaire> getCommentaireById(@PathVariable Integer commentaireId){
        return ResponseEntity
                .ok(this.commentaireService.getCommentaireById(commentaireId));
    }
    @PutMapping(path = "commentaire/editStatus/{commentaireId}")
    public ResponseEntity<Commentaire> disablePost(@PathVariable Integer commentaireId){
        return ResponseEntity
                .status(202)
                .body(this.commentaireService.editCommentaireStatus(commentaireId));
    }
    @PutMapping(path = "commentaire/update_by_id/{commentaireId}")
    public ResponseEntity<Commentaire> updateCommentaire(@RequestBody Commentaire commentaire,@PathVariable Integer commentaireId){
        return ResponseEntity
                .ok(this.commentaireService.updateCommentaire(commentaire, commentaireId));
    }
    @DeleteMapping(path = "commentaire/delete_by_id/{commentaireId}")
    public ResponseEntity<String> deleteCommentaire(@PathVariable Integer commentaireId){
        this.commentaireService.deleteCommentaire(commentaireId);
        return ResponseEntity
                .status(202)
                .body("your comment deleted successfully!!");
    }

}
