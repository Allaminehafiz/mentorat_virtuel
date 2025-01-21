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
            summary = "Affiche toutes les categories",
            description = "Cette méthode permet de lister toute les catégories."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "affiche toutes les categories")
    })
    @GetMapping(path = "categorie/get_all")
    public ResponseEntity<List<Categorie>> getAllCategorie(){

        return ResponseEntity
                .ok(this.categorieService.getAllCategorie());
    }
    @Operation(
            summary = "Affiche une categorie grace a Id",
            description = "Cette méthode permet d'afficher une catégorie grace a l'Id."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Affiche la categorie grace a l'Id")})
    @GetMapping(path = "categorie/get_by_id/{categorieId}")
    public ResponseEntity<Categorie> getCategorieById(@Valid @PathVariable Integer categorieId){
        return ResponseEntity
                .ok(this.categorieService.getCategorieById(categorieId));
    }
    @Operation(
            summary = "Affiche une page de categorie",
            description = "Cette méthode permet d'afficher une page de  catégorie ."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Affiche la page de categorie ")})
    @GetMapping(path = "categorie/pagination/{offset}/{pageSize}")
    public ResponseEntity<Page<CategorieRespDTO>> pagination(@PathVariable int offset,@PathVariable int pageSize){
        return ResponseEntity
                .ok(this.categorieService.pagination(offset, pageSize));
    }
    @Operation(
            summary = "Mise a jour de la catégorie",
            description = "Cette méthode permet de mettre a jour une catégorie dans la base de données."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La Catégorie a ete mise a jour avec succès"),
            @ApiResponse(responseCode = "400", description = "Les données envoyées sont invalides")
    })
    @PutMapping(path = "categorie/update/{categorieId}")
    public ResponseEntity<Categorie> updateCategorie(
            @RequestBody Categorie categorie,@PathVariable Integer categorieId){
        return ResponseEntity
                .ok(this.categorieService.updateCategorie(categorie, categorieId));
    }
    @Operation(
            summary = "Supprimer une nouvelle catégorie grace a l'ID",
            description = "Cette méthode permet de supprimer une catégorie dans la base de données."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Catégorie supprimee avec succès")
    })
    @DeleteMapping(path = "categorie/delete/{categorieId}")
    public ResponseEntity<String> deleteCategorieById(@PathVariable Integer categorieId){
        this.categorieService.deleteCategorieById(categorieId);
        return ResponseEntity
                .status(202)
                .body("category deleted successfully!!");
    }
}
