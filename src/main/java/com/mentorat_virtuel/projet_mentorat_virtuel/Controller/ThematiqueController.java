package com.mentorat_virtuel.projet_mentorat_virtuel.Controller;

import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.Thematique;
import com.mentorat_virtuel.projet_mentorat_virtuel.Service.ThematiqueService;
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
    public ResponseEntity<Thematique> addThematique(@RequestBody Thematique thematique){
        return ResponseEntity
                .status(201)
                .body(this.thematiqueService.addThematique(thematique));
    }
    @GetMapping(path = "thematique/getallthematique")
    public ResponseEntity<List<Thematique>> getAllThematique()
    {
        return ResponseEntity
                .status(200)
                .body(this.thematiqueService.getAllThematique());
    }
    @GetMapping(path = "thematique/getthematiquebyid/{id}")
    public ResponseEntity<Thematique> getThematiqueById(Integer id){
        return ResponseEntity
                .status(200)
                .body(this.thematiqueService.getThematiqueById(id));
    }
    @DeleteMapping(path = "thematique/deletethematique/{id}")
    public ResponseEntity<String> deleteThematique(Integer id){
        this.thematiqueService.deleteThematique(id);
        return ResponseEntity
                .status(202)
                .body("thematique deleted successfully");
    }

}
