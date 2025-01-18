package com.mentorat_virtuel.projet_mentorat_virtuel.service.categorie;

import com.mentorat_virtuel.projet_mentorat_virtuel.dto.categorie.CategorieReqDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.categorie.CategorieRespDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.entity.Categorie;

import java.util.List;

public interface CategorieService {
    CategorieRespDTO addCategorie(CategorieReqDTO categorieReqDTO);
    List<Categorie> getAllCategorie();
    Categorie getCategorieById(Integer categorieId);
    Categorie getCategorieByNom(String nom);
    Categorie updateCategorie(Categorie categorie,Integer categorieId);
    void deleteCategorieById(Integer categorieId);
}
