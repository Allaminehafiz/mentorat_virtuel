package com.mentorat_virtuel.projet_mentorat_virtuel.coltroller;

import com.mentorat_virtuel.projet_mentorat_virtuel.service.Location.LocationService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {

    public final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }


}
