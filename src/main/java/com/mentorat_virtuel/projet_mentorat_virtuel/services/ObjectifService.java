package com.mentorat_virtuel.projet_mentorat_virtuel.services;

import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Objectif;

import java.util.List;

public interface ObjectifService {
    Objectif addObjectif(Objectif objectif);
    List<Objectif> getAllObjectif();
    Objectif getObjectifById(int id);
    void deleteObjectifById(int id);
    Objectif updateObjectif(Objectif objectif);

}
