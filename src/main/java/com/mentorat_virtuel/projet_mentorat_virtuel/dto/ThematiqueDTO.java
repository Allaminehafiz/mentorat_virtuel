package com.mentorat_virtuel.projet_mentorat_virtuel.dto;

import org.hibernate.validator.constraints.Length;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public record ThematiqueDTO(  Integer Id,
         String libelle) {

}
