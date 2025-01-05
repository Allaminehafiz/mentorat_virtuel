package com.mentorat_virtuel.projet_mentorat_virtuel.service.user;

import com.github.slugify.Slugify;
import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Forum;
import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Sujet;
import com.mentorat_virtuel.projet_mentorat_virtuel.exception.ResourceExisteException;
import com.mentorat_virtuel.projet_mentorat_virtuel.exception.ResourceNotFoundException;
import com.mentorat_virtuel.projet_mentorat_virtuel.repositories.SujetRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SujetServiceImpl implements SujetService{
    private final SujetRepo sujetRepo;

    public SujetServiceImpl(SujetRepo sujetRepo) {
        this.sujetRepo = sujetRepo;
    }

    @Override
    public Sujet add(Sujet sujet) {
        final Slugify slg = Slugify.builder().build();
        Optional<Sujet> sujet1 = this.sujetRepo.findByTitle(sujet.getTitle());
        if(sujet1.isPresent())
            throw new ResourceExisteException("Sujet existe");
        sujet.setSlug(slg.slugify(sujet.getTitle()));
        sujet.setContent(sujet.getContent());
        sujet.setCreatedAt(new Date());
        sujet.setCreatedBy(sujet.getCreatedBy());
        return this.sujetRepo.save(sujet);
    }

    @Override
    public List<Sujet> getAllSujet() {

        return this.sujetRepo.findAll();
    }

    @Override
    public Sujet getById(Integer sujetId) {

        return this.sujetRepo.findById(sujetId).get();
    }

    @Override
    public Sujet updated(Sujet sujet, Integer sujetId) {
        Optional<Sujet> sujetToEdit = this.sujetRepo.findById(sujetId);
        if(sujetToEdit.isEmpty())
            throw new ResourceNotFoundException(" Le nom n'a pas ete trouve");
        if (sujet.getTitle() != null){
            sujetToEdit.get().setTitle(sujet.getTitle());
        }
        if (sujet.getContent() != null){
            sujetToEdit.get().setContent(sujet.getContent());
        }
        if (sujet.getCreatedBy() != null)
            sujetToEdit.get().setCreatedBy(sujet.getCreatedBy());
        return this.sujetRepo.saveAndFlush(sujetToEdit.get());

    }

    @Override
    public void delete(Integer sujetId) {
        this.sujetRepo.deleteById(sujetId);

    }
}
