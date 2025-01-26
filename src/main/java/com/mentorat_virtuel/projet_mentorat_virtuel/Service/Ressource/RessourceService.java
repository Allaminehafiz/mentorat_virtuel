package com.mentorat_virtuel.projet_mentorat_virtuel.Service.Ressource;

import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Ressource;

import java.util.List;

public interface RessourceService {
    Ressource addRessource (Ressource ressource);
    List<Ressource> getRessorceById ();
    Ressource getRessourceByid (Long id);
    Ressource updateRessourceByid (Ressource ressource, Long id);
    void deleteRessourceByid(Long id);
}
