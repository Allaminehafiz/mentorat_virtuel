package com.mentorat_virtuel.projet_mentorat_virtuel.services.LocationMentore;

import com.mentorat_virtuel.projet_mentorat_virtuel.entities.LocationMentore;

import java.util.List;

public interface LocationMentoreService {
    LocationMentore addLocationMentore(LocationMentore locationMentore);
    List<LocationMentore> getLocationMentores();
    LocationMentore getLocationMentoreById(Integer locationMentoreId);
    LocationMentore updateLocationMentore(LocationMentore locationMentore, Integer locationMentoreId);
    void deleteLocationMentore(Integer locationMentoreId);
}
