package com.mentorat_virtuel.projet_mentorat_virtuel.Controller;

import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.Thematique;
import com.mentorat_virtuel.projet_mentorat_virtuel.Service.ThematiqueService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ThematiqueController {
    private final ThematiqueService thematiqueService;

    public ThematiqueController(ThematiqueService thematiqueService) {
        this.thematiqueService = thematiqueService;
    }
    @PostMapping(path = "thematique/add")
    @ResponseBody
    public ResponseEntity<Thematique> addThematique(@Valid @RequestBody Thematique thematique){
        return ResponseEntity
                .status(201)
                .body(this.thematiqueService.addThematique(thematique));
    }
    @GetMapping(path = "thematique/get-thematique")
    public ResponseEntity<List<Thematique>> getThematiqueById()
    {
        return ResponseEntity
                .status(200)
                .body(this.thematiqueService.getAllThematique());
    }
    @GetMapping(path = "thematique/get-thematique-by-id/{thematiqueId}")
    public ResponseEntity<Thematique> getThematiqueById(@PathVariable Integer thematiqueId){
        return ResponseEntity
                .status(200)
                .body(this.thematiqueService.getThematiqueById(thematiqueId));
    }
    @PatchMapping(path = "thematique/update-by-id/{thematiqueId}")
    public ResponseEntity<Thematique> updateThematiqueById(@PathVariable Integer thematiqueId,@RequestBody Thematique thematique ){
        return  ResponseEntity
                .status(202)
                .body(this.thematiqueService.updateThematiqueById(thematique, thematiqueId));
    }
    @DeleteMapping(path = "thematique/deletethematique/{thematiqueId}")
    public ResponseEntity<String> deleteThematiqueById(@PathVariable Integer thematiqueId){
        this.thematiqueService.deleteThematique(thematiqueId);
        return ResponseEntity
                .status(202)
                .body("thematique deleted successfully");
    }

}
