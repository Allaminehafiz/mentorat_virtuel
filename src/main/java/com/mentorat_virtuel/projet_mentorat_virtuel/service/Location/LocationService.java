package com.mentorat_virtuel.projet_mentorat_virtuel.service.Location;

import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Location;

import java.util.List;

public interface LocationService {
    Location addLocation(Location location);
    List<Location> getLocation();
    Location getLocationById(Integer locationId);
    Location updateLocation(Location location , Integer locationId);
    void deleteLocation(Integer locationId);
}
