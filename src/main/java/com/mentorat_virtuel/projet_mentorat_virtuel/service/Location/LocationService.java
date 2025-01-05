package com.mentorat_virtuel.projet_mentorat_virtuel.service.Location;

import com.mentorat_virtuel.projet_mentorat_virtuel.dto.LocationReqDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Location;
import jakarta.validation.Valid;

import java.util.List;

public interface LocationService {
    Location addLocation(@Valid Location location);
    List<Location> getLocations();
    Location getLocationById(Integer locationId);
    Location updateLocation(Location location , Integer locationId);
    void deleteLocation(Integer locationId);
}
