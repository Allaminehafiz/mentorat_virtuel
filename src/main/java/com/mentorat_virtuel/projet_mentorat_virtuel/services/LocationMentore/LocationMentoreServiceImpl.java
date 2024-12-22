package com.mentorat_virtuel.projet_mentorat_virtuel.services.LocationMentore;

import com.mentorat_virtuel.projet_mentorat_virtuel.entities.LocationMentore;
import com.mentorat_virtuel.projet_mentorat_virtuel.exception.ResourceNotFoundException;
import com.mentorat_virtuel.projet_mentorat_virtuel.repositories.LocationMentoreRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LocationMentoreServiceImpl implements LocationMentoreService {
    final LocationMentoreRepo locationMentoreRepo;

    public LocationMentoreServiceImpl(LocationMentoreRepo locationMentoreRepo) {
        this.locationMentoreRepo = locationMentoreRepo;
    }

    @Override
    public LocationMentore addLocationMentore(LocationMentore locationMentore) {
        locationMentore.setCreatedAt(new Date());
        locationMentore.setStatus(true);
        return this.locationMentoreRepo.save(locationMentore);
    }

    @Override
    public List<LocationMentore> getLocationMentores() {

        return this.locationMentoreRepo.findAll();
    }

    @Override
    public LocationMentore getLocationMentoreById(Integer locationMentoreId) {

        return this.locationMentoreRepo.findById(locationMentoreId).get();
    }

    @Override
    public LocationMentore updateLocationMentore(LocationMentore locationMentore, Integer locationMentoreId) {
        //Recherche
        Optional<LocationMentore> locationMentoreToEdit = this.locationMentoreRepo.findById(locationMentoreId);
        if (locationMentoreToEdit.isEmpty())
            throw new ResourceNotFoundException("Location not found !");
        //Modidier les informations
        if (locationMentore.getTown() != null)
            locationMentoreToEdit.get().setTown(locationMentore.getTown());
        if (locationMentore.getStreet() != null)
            locationMentoreToEdit.get().setStreet(locationMentore.getStreet());
        if (locationMentore.getPostalCode() != null)
            locationMentoreToEdit.get().setPostalCode(locationMentore.getPostalCode());
        locationMentoreToEdit.get().setUpdatedAt(new Date());
        //Sauvegarder les modifications
        return this.locationMentoreRepo.saveAndFlush(locationMentoreToEdit.get());
    }

    @Override
    public void deleteLocationMentore(Integer locationMentoreId) {
        LocationMentore locationMentore = this.locationMentoreRepo.findById(locationMentoreId)
                .orElseThrow(()->new ResourceNotFoundException("Location not found"));
        this.locationMentoreRepo.delete(locationMentore);
    }
}
