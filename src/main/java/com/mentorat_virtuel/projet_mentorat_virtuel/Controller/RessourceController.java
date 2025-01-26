package com.mentorat_virtuel.projet_mentorat_virtuel.Controller;

import com.mentorat_virtuel.projet_mentorat_virtuel.Service.Ressource.RessourceServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RessourceController {
    private final RessourceServiceImpl ressourceService;

    public RessourceController(RessourceServiceImpl ressourceService) {
        this.ressourceService = ressourceService;
    }
}
