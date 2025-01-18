package com.mentorat_virtuel.projet_mentorat_virtuel.mapper;

import com.mentorat_virtuel.projet_mentorat_virtuel.dto.categorie.CategorieReqDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.categorie.CategorieRespDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.entity.Categorie;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategorieMapper {

    Categorie fromCategorieReqDTO(CategorieReqDTO categorieReqDTO);
    CategorieRespDTO fromCategorie(Categorie categorie);
}

