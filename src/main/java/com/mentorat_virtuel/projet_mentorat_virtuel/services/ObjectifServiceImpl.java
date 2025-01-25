package com.mentorat_virtuel.projet_mentorat_virtuel.services;

import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Objectif;
import com.mentorat_virtuel.projet_mentorat_virtuel.repositories.ObjectifRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class  ObjectifServiceImpl implements ObjectifService {

    private final ObjectifRepo objectifRepo;

    public ObjectifServiceImpl(ObjectifRepo objectifRepo) {
        this.objectifRepo = objectifRepo;
    }

    public List<Objectif> getAllObjectifs() {
        return objectifRepo.findAll();
    }

    @Override
    public Objectif getObjectifById(int objectifId) {
        return objectifRepo.findById(objectifId).get();
    }

    @Override
    public Objectif addObjectif(Objectif objectif) {

        return objectifRepo.save(objectif);
    }

    @Override
    public List<Objectif> getAllObjectif() {
        return List.of();
    }

    @Override
    public Objectif updateObjectif(Objectif objectif){

        return objectifRepo.save(objectif);
    }


    @Override
    public void deleteObjectifById(int objectifId) {
        objectifRepo.deleteById(objectifId);

    }



    }


