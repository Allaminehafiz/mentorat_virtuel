package com.mentorat_virtuel.projet_mentorat_virtuel.controller;

import com.mentorat_virtuel.projet_mentorat_virtuel.dto.categorie.CategorieReqDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.categorie.CategorieRespDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.entity.Categorie;
import com.mentorat_virtuel.projet_mentorat_virtuel.service.categorie.CategorieService;
import com.mentorat_virtuel.projet_mentorat_virtuel.service.categorie.CategorieServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategorieController {
    private final CategorieService categorieService;

    public CategorieController(CategorieServiceImpl categorieService) {
        this.categorieService = categorieService;
    }

    @Operation(
            summary = "Ajouter une nouvelle catégorie",
            description = "Cette méthode permet d'ajouter une nouvelle catégorie dans la base de données."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Catégorie ajoutée avec succès"),
            @ApiResponse(responseCode = "400", description = "Les données envoyées sont invalides")
    })
    @PostMapping(path = "categorie/add")
    @ResponseBody
    public ResponseEntity<CategorieRespDTO> addCategorie(
            @RequestBody
            @Valid
            @Parameter(description = "Catégorie à ajouter", required = true)
            CategorieReqDTO categorieReqDTO
    ) {
        CategorieRespDTO categorieRespDTO = categorieService.addCategorie(categorieReqDTO);
        return new ResponseEntity<>(categorieRespDTO, HttpStatus.CREATED);
    }
    @Operation(
            summary = "Recuperer la liste des categories",
            description = "Cette méthode permet de recuperer une liste complete de toutes les catégories."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "liste des categories recuperee aec success")
    })
    @GetMapping(path = "categorie/get_all")
    public ResponseEntity<List<Categorie>> getAllCategorie(){

        return ResponseEntity
                .ok(this.categorieService.getAllCategorie());
    }
    @Operation(
            summary = "Récupérer une catégorie par son identifiant",
            description = "Cette méthode permet de récupérer une catégorie spécifique en utilisant son identifiant unique."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La catégorie a été récupérée avec succès."),
            @ApiResponse(responseCode = "404", description = "Catégorie non trouvée pour l'ID donné.")
    })
    @GetMapping(path = "categorie/get_by_id/{categorieId}")
    public ResponseEntity<Categorie> getCategorieById(@Valid @PathVariable Integer categorieId){
        return ResponseEntity
                .ok(this.categorieService.getCategorieById(categorieId));
    }
    @Operation(
            summary = "Récupérer une page de catégories",
            description = "Cette méthode permet de récupérer une page de catégories avec un offset et une taille de page spécifiques."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Page de catégories récupérée avec succès."),
            @ApiResponse(responseCode = "400", description = "Paramètres de pagination invalides.")
    })
    @GetMapping(path = "categorie/pagination/{offset}/{pageSize}")
    public ResponseEntity<Page<CategorieRespDTO>> pagination(@PathVariable int offset,@PathVariable int pageSize){
        return ResponseEntity
                .ok(this.categorieService.pagination(offset, pageSize));
    }
    @Operation(
            summary = "Récupérer une catégorie par son nom",
            description = "Cette méthode permet de récupérer une catégorie spécifique en utilisant son nom."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La catégorie a été récupérée avec succès."),
            @ApiResponse(responseCode = "404", description = "Catégorie non trouvée pour le nom donné.")
    })
    @GetMapping(path = "categorie/get-by-nom/{nom}")
    public ResponseEntity<Categorie> getCategorieByNom(@PathVariable String nom){
        return ResponseEntity
                .ok(this.categorieService.findCategorieByNom(nom));
    }
    @Operation(
            summary = "Mettre à jour une catégorie existante",
            description = "Cette méthode permet de mettre à jour les informations d'une catégorie existante dans la base de données."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La catégorie a été mise à jour avec succès."),
            @ApiResponse(responseCode = "400", description = "Les données envoyées sont invalides ou incomplètes.")
    })
    @PutMapping(path = "categorie/update/{categorieId}")
    public ResponseEntity<Categorie> updateCategorie(
            @RequestBody Categorie categorie,@PathVariable Integer categorieId){
        return ResponseEntity
                .ok(this.categorieService.updateCategorie(categorie, categorieId));
    }
    @Operation(
            summary = "Supprimer une catégorie par son identifiant",
            description = "Cette méthode permet de supprimer une catégorie de la base de données en utilisant son identifiant unique."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Catégorie supprimée avec succès."),
            @ApiResponse(responseCode = "404", description = "Catégorie non trouvée pour l'ID donné.")
    })
    @DeleteMapping(path = "categorie/delete/{categorieId}")
    public ResponseEntity<String> deleteCategorieById(@PathVariable Integer categorieId){
        this.categorieService.deleteCategorieById(categorieId);
        return ResponseEntity
                .status(202)
                .body("category deleted successfully!!");
    }
}
