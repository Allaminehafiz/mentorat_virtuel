package com.mentorat_virtuel.projet_mentorat_virtuel.controller;

import com.mentorat_virtuel.projet_mentorat_virtuel.dto.commentaire.CommentaireReqDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.commentaire.CommentaireRespDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.entity.Commentaire;
import com.mentorat_virtuel.projet_mentorat_virtuel.service.commentaire.CommentaireService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
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
    @Operation(
            summary = "Ajouter un nouveau commentaire",
            description = "Cette méthode permet d'ajouter un nouveau commentaire dans la base de données."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Commentaire ajoutée avec succès"),
            @ApiResponse(responseCode = "400", description = "Les données envoyées sont invalides")
    })
    @PostMapping(path = "commentaire/add")
    @ResponseBody
    public ResponseEntity<CommentaireRespDTO> addCommentaire(@Valid @RequestBody CommentaireReqDTO commentaireReqDTO){

        CommentaireRespDTO commentaireRespDTO = this.commentaireService.addCommentaire(commentaireReqDTO);
        return new ResponseEntity<>(commentaireRespDTO,HttpStatus.CREATED);
    }
    @Operation(
            summary = "Affiche tout les commentaire",
            description = "Cette méthode permet d'afficher  tout les commentaire present dans la base de données."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste de tout les commentaires")})
    @GetMapping(path = "commentaire/get_all_commentaire")
    public ResponseEntity<List<Commentaire>> getAllCommentaire(){
        return ResponseEntity
                .ok(this.commentaireService.getAllCommentaire());
    }
    @Operation(
            summary = "Affiche un commentaire grace a l'ID",
            description = "Cette méthode permet d'afficher un commentaire grace a son ID dans la base de donnee."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Affiche un commentaire grace a l'ID")})
    @GetMapping(path = "commentaire/get_commentaire_by_id/{commentaireId}")
    public ResponseEntity<Commentaire> getCommentaireById(@PathVariable Integer commentaireId){
        return ResponseEntity
                .ok(this.commentaireService.getCommentaireById(commentaireId));
    }

    @Operation(
            summary = "Mise A Jour d'un Commentaire",
            description = "Cette méthode permet la mise a jour d'un commentaire dans la base de données."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mise a jour reussi"),
            @ApiResponse(responseCode = "400", description = "Les données envoyées sont invalides")
    })
    @PutMapping(path = "commentaire/update_by_id/{commentaireId}")
    public ResponseEntity<Commentaire> updateCommentaire(@Valid @RequestBody Commentaire commentaire,@PathVariable Integer commentaireId){
        return ResponseEntity
                .ok(this.commentaireService.updateCommentaire(commentaire, commentaireId));
    }
    @Operation(
            summary = "Supprimer un Commentaire grace a l'ID",
            description = "Cette méthode permet de supprimee un commentaire dans la base de données."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Commentaire supprime avec success"),
    })
    @DeleteMapping(path = "commentaire/delete_by_id/{commentaireId}")
    public ResponseEntity<String> deleteCommentaire(@PathVariable Integer commentaireId){
        this.commentaireService.deleteCommentaire(commentaireId);
        return ResponseEntity
                .status(200)
                .body("your comment deleted successfully!!");
    }

}
