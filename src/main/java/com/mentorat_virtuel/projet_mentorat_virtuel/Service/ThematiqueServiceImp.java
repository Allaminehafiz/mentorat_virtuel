package com.mentorat_virtuel.projet_mentorat_virtuel.Service;

import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.Thematique;
import com.mentorat_virtuel.projet_mentorat_virtuel.Repository.ThematiqueRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ThematiqueServiceImp implements ThematiqueService {
    private final ThematiqueRepo thematiqueRepo;

    public ThematiqueServiceImp(ThematiqueRepo thematiqueRepo) {
        this.thematiqueRepo = thematiqueRepo;
    }

    @Override
    public Thematique addThematique(Thematique thematique) {
        return this.thematiqueRepo.save(thematique);
    }

    @Override
    public List<Thematique> getAllThematique() {
        return this.thematiqueRepo.findAll();
    }

    @Override
    public Thematique getThematiqueById(Integer thematiqueId) {
        return this.thematiqueRepo.findById(thematiqueId).get();
    }

    @Override
    public Thematique updatedThematique(Thematique thematique, Integer thematiqueId) {
        return null;
    }

    @Override
    public void deleteThematique(Integer thematiqueId) {
        this.thematiqueRepo.deleteById(thematiqueId);

    }
}
