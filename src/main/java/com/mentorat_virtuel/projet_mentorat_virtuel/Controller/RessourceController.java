package com.mentorat_virtuel.projet_mentorat_virtuel.Controller;

import com.mentorat_virtuel.projet_mentorat_virtuel.Service.Ressource.RessourceServiceImpl;
import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Ressource;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RessourceController {
    private final RessourceServiceImpl ressourceService;

    public RessourceController(RessourceServiceImpl ressourceService) {
        this.ressourceService = ressourceService;
    }
    @PostMapping("api/v1/ressource/add")
    public ResponseEntity<Ressource> addRessouce(@RequestBody @Valid Ressource ressource){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.ressourceService.addRessource(ressource));
}

}
