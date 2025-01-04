package com.mentorat_virtuel.projet_mentorat_virtuel.coltroller;

import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Location;
import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Mentore;
import com.mentorat_virtuel.projet_mentorat_virtuel.service.Location.LocationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocationController {

    public final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping(path = "location/add")
    public ResponseEntity<Location> addLocation(@Valid @RequestBody Location location){

        return ResponseEntity
                .status(201)
                .body(this.locationService.addLocation(location));
    }

    @GetMapping(path = "locations/get_all")
    public ResponseEntity<List<Location>> getLocations(){

        return ResponseEntity
                .status(200)
                .body(this.locationService.getLocations());
    }

    @GetMapping(path = "locations/get_by_id/{locationId}")
    public ResponseEntity<Location> getLocationById(@PathVariable Integer locationId){

        return ResponseEntity
                .status(200)
                .body(this.locationService.getLocationById(locationId));
    }

    @PutMapping(path = "location/update_by_id/{locationId}")
    public ResponseEntity<Location> updateLocationById(@PathVariable Integer locationId, @Valid @RequestBody  Location location){

        return ResponseEntity
                .status(202)
                .body(this.locationService.updateLocation(location,locationId));
    }

    @DeleteMapping(path = "location/delete_by_id/{locationId}")
    public ResponseEntity<String> deleteLocationById(@PathVariable Integer locationId){
        this.locationService.deleteLocation(locationId);
        return ResponseEntity
                .status(202)
                .body("Deleted successfully !");
    }
}
