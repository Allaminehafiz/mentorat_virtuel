package com.mentorat_virtuel.projet_mentorat_virtuel.Service;

import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.Thematique;
import com.mentorat_virtuel.projet_mentorat_virtuel.Exception.ResourceNotFoundException;
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
        return this.thematiqueRepo.findById(thematiqueId).orElseThrow(() -> new ResourceNotFoundException("Thematique with ID not found" ));
    }

    @Override
    public Thematique updateThematiqueById(Thematique thematique, Integer thematiqueId) {
        Thematique thematiqueToEdit= this.thematiqueRepo.findById(thematiqueId).get();
        thematiqueToEdit.setLibelle(thematique.getLibelle());
        return this.thematiqueRepo.saveAndFlush(thematiqueToEdit);

    }


    @Override
    public void deleteThematique(Integer thematiqueId) {
        this.thematiqueRepo.deleteById(thematiqueId);

    }
}
