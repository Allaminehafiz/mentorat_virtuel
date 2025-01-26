package com.mentorat_virtuel.projet_mentorat_virtuel.Service.Ressource;

import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Ressource;
import com.mentorat_virtuel.projet_mentorat_virtuel.repository.RessourceRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RessourceServiceImpl implements RessourceService {
    private final RessourceRepo ressourceRepo;


    public RessourceServiceImpl(RessourceRepo ressourceRepo) {
        this.ressourceRepo = ressourceRepo;
    }

    @Override
    public Ressource addRessource(Ressource ressource) {
        return null;
    }

    @Override
    public List<Ressource> getRessorceById() {
        return List.of();
    }

    @Override
    public Ressource getRessourceByid(Long id) {
        return null;
    }

    @Override
    public Ressource updateRessourceByid(Ressource ressource, Long id) {
        return null;
    }

    @Override
    public void deleteRessourceByid(Long id) {

    }
}
