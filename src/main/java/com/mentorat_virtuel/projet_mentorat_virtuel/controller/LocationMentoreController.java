package com.mentorat_virtuel.projet_mentorat_virtuel.controller;

import com.mentorat_virtuel.projet_mentorat_virtuel.entities.LocationMentore;
import com.mentorat_virtuel.projet_mentorat_virtuel.services.LocationMentore.LocationMentoreServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocationMentoreController {

    private final LocationMentoreServiceImpl locationMentoreService;

    public LocationMentoreController(LocationMentoreServiceImpl locationMentoreService) {
        this.locationMentoreService = locationMentoreService;
    }

    @PostMapping(path = "LocationMentore/add")
    public ResponseEntity<LocationMentore> addCustomer(@Valid @RequestBody LocationMentore locationMentore){

        return ResponseEntity
                .status(201)
                .body(this.locationMentoreService.addLocationMentore(locationMentore));
    }
    @GetMapping(path = "locations/get_all")
    public ResponseEntity<List<LocationMentore>> getLocationMentores(){

        return ResponseEntity
                .status(200)
                .body(this.locationMentoreService.getLocationMentores());
    }
    @GetMapping(path = "Locations/get_by_id/{LocationMentoreId}")
    public ResponseEntity<LocationMentore> getLocationMentoreById(@PathVariable Integer locationMentoreId){

        return ResponseEntity
                .status(200)
                .body(this.locationMentoreService.getLocationMentoreById(locationMentoreId));
    }
    @PutMapping(path = "locations/update_by_id/{locationMentoreId}")
    public ResponseEntity<LocationMentore> updateLocationMentoreById(@PathVariable Integer locationMentoreId, @Valid @RequestBody LocationMentore locationMentore){

        return ResponseEntity
                .status(202)
                .body(this.locationMentoreService.updateLocationMentore(locationMentore,locationMentoreId));
    }

    @DeleteMapping(path = "locations/delete_by_id/{locationMentoreId}")
    public ResponseEntity<String> deleteLocationMentoreById(@PathVariable Integer locationMentoreId){
        this.locationMentoreService.deleteLocationMentore(locationMentoreId);
        return ResponseEntity
                .status(202)
                .body("Deleted successfully !");
    }


}
