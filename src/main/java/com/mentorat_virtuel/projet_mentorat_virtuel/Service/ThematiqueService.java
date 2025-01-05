package com.mentorat_virtuel.projet_mentorat_virtuel.Service;

import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.Thematique;

import java.util.List;

public interface ThematiqueService {
    Thematique addThematique(Thematique thematique);
    List<Thematique> getAllThematique();
    Thematique getThematiqueById(Integer thematiqueId);
    Thematique updateThematiqueById(Thematique thematique, Integer thematiqueId);



    void deleteThematique(Integer thematiqueId);
}
