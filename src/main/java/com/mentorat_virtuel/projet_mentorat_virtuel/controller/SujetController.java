package com.mentorat_virtuel.projet_mentorat_virtuel.controller;

import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Sujet;
import com.mentorat_virtuel.projet_mentorat_virtuel.service.user.SujetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SujetController {
    private final SujetService sujetService;

    public SujetController(SujetService sujetService) {

        this.sujetService = sujetService;
    }

    @PostMapping(path = "sujet/add")
    public ResponseEntity<Sujet> add(@RequestBody Sujet sujet){
        return ResponseEntity.status(201).body(this.sujetService.add(sujet));
    }

    @GetMapping(path = "sujet/getAll")
    public ResponseEntity<List<Sujet>> getAll(){
        return ResponseEntity.status(200).body(this.sujetService.getAllSujet());
    }

    @GetMapping( path = "sujet/getbyId{sujetId}")
    public ResponseEntity<Sujet> getbyid(@PathVariable Integer sujetId){
        return ResponseEntity.status(200).body(this.sujetService.getById(sujetId));
    }

    @PutMapping( path = "sujet/updated{sujetId}")
    public ResponseEntity<Sujet> updated(@RequestBody Sujet sujet,@PathVariable Integer sujetId){
        return ResponseEntity.status(200).body(this.sujetService.updated(sujet, sujetId));
    }

    @DeleteMapping( path = "sujet/delete{sujetId}")
    public ResponseEntity<String> delete(Integer sujetId){
        this.sujetService.delete(sujetId);
        return ResponseEntity.status(202).body("Delete sucessfully !!");
    }
}
