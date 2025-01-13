package com.mentorat_virtuel.projet_mentorat_virtuel.service;

import com.mentorat_virtuel.projet_mentorat_virtuel.entity.Categorie;

import java.util.List;

public interface CategorieService {
    Categorie addCategorie(Categorie categorie);
    List<Categorie> getAllCategorie();
    Categorie getCategorieById(Integer categorieId);
    Categorie getCategorieByNom(String nom);
    Categorie editCategorieStatus(Integer categorieId);
    Categorie updateCategorie(Categorie categorie,Integer categorieId);
    void deleteCategorieById(Integer categorieId);
}
