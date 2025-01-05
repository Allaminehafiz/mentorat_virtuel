package com.mentorat_virtuel.projet_mentorat_virtuel.Controller;

import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.RDV;
import com.mentorat_virtuel.projet_mentorat_virtuel.Service.RDVService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RDVController {
    private RDVService rdvService;

    public RDVController(RDVService rdvService) {
        this.rdvService = rdvService;
    }
    @PostMapping("rdv/add")
    public ResponseEntity<RDV> addRDV(@Valid @RequestBody RDV rdv) {
        RDV rdv1 = this.rdvService.addRDV(rdv);
        return ResponseEntity
                .status(201)
                .body(rdv1);

    }
    @GetMapping(path = "rdv/get_all")
    public ResponseEntity<List<RDV>> getRdv(){
        return ResponseEntity
                .status(200)
                .body(this.rdvService.getRDV());
    }

    @GetMapping(path = "rdv/get-all")
    public ResponseEntity<RDV> getRDVById(@PathVariable Integer rdvId){
        return ResponseEntity
                .status(200)
                .body(this.rdvService.getRDVById(rdvId));

    }
    @PatchMapping(path = "rdv/update-by-id/{rdvId}")
    public ResponseEntity<RDV> updateRDVById(@PathVariable Integer rdvId,@RequestBody RDV rdv ){
        return  ResponseEntity
                .status(202)
                .body(this.rdvService.updatedRDVById(rdv, rdvId));
    }
    @DeleteMapping(path = "rdv/delete_by_id/{rdvId}")
    public ResponseEntity<String> deleteRDVById(@PathVariable Integer rdvId){
        this.rdvService.deleteRDV(rdvId);
        return ResponseEntity
                .status(202)
                .body("Deleted successfully !");
    }
}
