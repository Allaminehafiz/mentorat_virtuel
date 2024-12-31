package com.mentorat_virtuel.projet_mentorat_virtuel.service.Location;

import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Location;
import com.mentorat_virtuel.projet_mentorat_virtuel.repositories.LocationRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepo locationRepo;

    public LocationServiceImpl(LocationRepo locationRepo) {
        this.locationRepo = locationRepo;
    }

    @Override
    public Location addLocation(Location location) {
        return null;
    }

    @Override
    public List<Location> getLocation() {
        return List.of();
    }

    @Override
    public Location getLocationById(Integer locationId) {
        return null;
    }

    @Override
    public Location updateLocation(Location location, Integer locationId) {
        return null;
    }

    @Override
    public Location deleteLocation(Integer locationId) {
        return null;
    }
}
