package com.mentorat_virtuel.projet_mentorat_virtuel.Mapper;

import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.Thematique;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.ThematiqueDTO;
import org.mapstruct.Mapping;

import java.util.function.Function;

public interface ThematiqueDTOMapper {
@Mapping(source = "thematique",target = "thematiqueDTO")
    ThematiqueDTO fromThematique(Thematique thematique);
}
