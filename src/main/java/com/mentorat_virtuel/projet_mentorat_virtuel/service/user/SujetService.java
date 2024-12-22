package com.mentorat_virtuel.projet_mentorat_virtuel.service.user;

import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Forum;
import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Sujet;

import java.util.List;

public interface SujetService {
    Sujet add(Sujet sujet);
    List<Sujet> getAll();
    Sujet getById(Integer sujetId);
    Sujet updated(Sujet sujet, Integer sujetId);
    void delete(Integer sujetId);

}
