package com.mentorat_virtuel.projet_mentorat_virtuel.controller;

import com.mentorat_virtuel.projet_mentorat_virtuel.dto.commentaire.CommentaireReqDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.commentaire.CommentaireRespDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.entity.Commentaire;
import com.mentorat_virtuel.projet_mentorat_virtuel.service.commentaire.CommentaireService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
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
            summary = "Récupérer la liste de tous les commentaires",
            description = "Cette méthode permet de récupérer tous les commentaires présents dans la base de données."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La liste de tous les commentaires a été récupérée avec succès.")
    })
    @GetMapping(path = "commentaire/get_all_commentaire")
    public ResponseEntity<List<Commentaire>> getAllCommentaire(){
        return ResponseEntity
                .ok(this.commentaireService.getAllCommentaire());
    }
    @Operation(
            summary = "Récupérer une page de commentaires",
            description = "Cette méthode permet de récupérer une page de commentaires, en fonction des paramètres d'offset et de taille de page fournis."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Page de commentaires récupérée avec succès."),
            @ApiResponse(responseCode = "400", description = "Les paramètres de pagination sont invalides.")
    })
    @GetMapping(path = "commentaire/pagination/{offset}/{pageSize}")
    public ResponseEntity<Page<CommentaireRespDTO>> pagination(@PathVariable int offset,@PathVariable int pageSize){
        return ResponseEntity
                .ok(this.commentaireService.pagination(offset, pageSize));
    }
    @Operation(
            summary = "Récupérer un commentaire par son identifiant",
            description = "Cette méthode permet de récupérer un commentaire spécifique en utilisant son identifiant unique dans la base de données."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Le commentaire a été récupéré avec succès."),
            @ApiResponse(responseCode = "404", description = "Commentaire non trouvé pour l'ID donné.")
    })
    @GetMapping(path = "commentaire/get_commentaire_by_id/{commentaireId}")
    public ResponseEntity<Commentaire> getCommentaireById(@PathVariable Integer commentaireId){
        return ResponseEntity
                .ok(this.commentaireService.getCommentaireById(commentaireId));
    }

    @Operation(
            summary = "Mettre à jour un commentaire existant",
            description = "Cette méthode permet de mettre à jour un commentaire existant dans la base de données avec de nouvelles informations."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Le commentaire a été mis à jour avec succès."),
            @ApiResponse(responseCode = "400", description = "Les données envoyées sont invalides ou incomplètes.")
    })
    @PutMapping(path = "commentaire/update_by_id/{commentaireId}")
    public ResponseEntity<Commentaire> updateCommentaire(@Valid @RequestBody Commentaire commentaire,@PathVariable Integer commentaireId){
        return ResponseEntity
                .ok(this.commentaireService.updateCommentaire(commentaire, commentaireId));
    }
    @Operation(
            summary = "Supprimer un commentaire par son identifiant",
            description = "Cette méthode permet de supprimer un commentaire spécifique de la base de données en utilisant son identifiant unique."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Le commentaire a été supprimé avec succès."),
            @ApiResponse(responseCode = "404", description = "Commentaire non trouvé pour l'ID donné.")
    })
    @DeleteMapping(path = "commentaire/delete_by_id/{commentaireId}")
    public ResponseEntity<String> deleteCommentaire(@PathVariable Integer commentaireId){
        this.commentaireService.deleteCommentaire(commentaireId);
        return ResponseEntity
                .status(200)
                .body("your comment deleted successfully!!");
    }

}
