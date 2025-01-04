package com.mentorat_virtuel.projet_mentorat_virtuel.service.Location;

import com.mentorat_virtuel.projet_mentorat_virtuel.Exception.ResourceNotFoundException;
import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Location;
import com.mentorat_virtuel.projet_mentorat_virtuel.repositories.LocationRepo;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepo locationRepo;

    public LocationServiceImpl(LocationRepo locationRepo) {
        this.locationRepo = locationRepo;
    }

    @Override
    public Location addLocation(Location location) {
        //location.setCreatedAt(Instant.now());
        //location.setStatus(true);
        return this.locationRepo.save(location);
    }

    @Override
    public List<Location> getLocations() {
        return this.locationRepo.findAll() ;
    }

    @Override
    public Location getLocationById(Integer locationId) {

        return this.locationRepo.findById(locationId).orElseThrow(
                ()-> new ResourceNotFoundException("Location not found !")
        );
    }

    @Override
    public Location updateLocation(Location location, Integer locationId) {
        //Recherche
        Optional<Location> locationToEdit = this.locationRepo.findById(locationId);
        if (locationToEdit.isEmpty())
            throw new ResourceNotFoundException("Location not found !");
        //Modidier les informations
        if (location.getTown() != null)
            locationToEdit.get().setTown(location.getTown());
        if (location.getStreet() != null)
            locationToEdit.get().setStreet(location.getStreet());
        if (location.getPostalCode() != null)
            locationToEdit.get().setPostalCode(location.getPostalCode());
        locationToEdit.get().setUpdatedAt(new Date());
        //Sauvegarder les modifications
        return this.locationRepo.saveAndFlush(locationToEdit.get());
    }

    @Override
    public void deleteLocation(Integer locationId) {
        Location location = this.locationRepo.findById(locationId)
                .orElseThrow(()->new ResourceNotFoundException("Location not found"));
        this.locationRepo.delete(location);
    }
}
