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

    @GetMapping(path = "mentores/get_by_id/{mentoreId}")
    public ResponseEntity<Mentore> getMentoreById(@PathVariable Integer mentoreId){

        return ResponseEntity
                .status(200)
                .body(this.mentoreService.getMentoreById(mentoreId));
    }

    @GetMapping(path = "mentores/get_by_email{email}")
    public ResponseEntity<Mentore> getMentoreByEmail(@PathVariable String email){

        return ResponseEntity
                .status(200)
                .body(this.mentoreService.getMentoreByEmail(email));
    }

    @PutMapping(path = "mentores/update_by_id/{mentoreId}")
    public ResponseEntity<Mentore> updateMentoreById(@PathVariable Integer mentoreId, @Valid @RequestBody  Mentore mentore){

        return ResponseEntity
                .status(202)
                .body(this.mentoreService.updateMentore(mentore,mentoreId));
    }

    @DeleteMapping(path = "mentores/delete_by_id/{mentoreId}")
    public ResponseEntity<String> deleteMentoreById(@PathVariable Integer mentoreId){
        this.mentoreService.deleteMentore(mentoreId);
        return ResponseEntity
                .status(202)
                .body("Deleted successfully !");
    }
}
