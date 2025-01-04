package com.mentorat_virtuel.projet_mentorat_virtuel.coltroller;

import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Mentore;
import com.mentorat_virtuel.projet_mentorat_virtuel.service.Mentore.MentoreService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MentoreController {
    public final MentoreService mentoreService;

    public MentoreController(MentoreService mentoreService) {
        this.mentoreService = mentoreService;
    }

    @PostMapping(path = "mentores/add")
    public ResponseEntity<Mentore> addMentore(@Valid @RequestBody Mentore mentore){

        return ResponseEntity
                .status(201)
                .body(this.mentoreService.addMentore(mentore));
    }

    @GetMapping(path = "mentores/get_all")
    public ResponseEntity<List<Mentore>> getMentores(){

        return ResponseEntity
                .status(200)
                .body(this.mentoreService.getMentores());
    }
}
