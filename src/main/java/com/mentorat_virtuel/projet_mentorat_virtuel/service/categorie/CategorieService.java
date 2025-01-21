package com.mentorat_virtuel.projet_mentorat_virtuel.service.categorie;

import com.mentorat_virtuel.projet_mentorat_virtuel.dto.categorie.CategorieReqDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.categorie.CategorieRespDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.entity.Categorie;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategorieService {
    CategorieRespDTO addCategorie(CategorieReqDTO categorieReqDTO);
    List<Categorie> getAllCategorie();
    Categorie getCategorieById(Integer categorieId);
    Page<CategorieRespDTO> pagination(int offset,int pageSize);
    Categorie findCategorieByNom(String nom);
    Categorie updateCategorie(Categorie categorie,Integer categorieId);
    void deleteCategorieById(Integer categorieId);
}
