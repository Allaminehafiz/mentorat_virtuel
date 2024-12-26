package com.mentorat_virtuel.projet_mentorat_virtuel.service.user;

import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Forum;
import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Sujet;
import com.mentorat_virtuel.projet_mentorat_virtuel.repositories.SujetRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SujetServiceImpl implements SujetService{
    private final SujetRepo sujetRepo;

    public SujetServiceImpl(SujetRepo sujetRepo) {
        this.sujetRepo = sujetRepo;
    }

    @Override
    public Sujet add(Sujet sujet) {
        sujet.setTitle(sujet.getTitle());
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
        Sujet sujetToEdit = this.sujetRepo.findById(sujetId).get();
        if (sujet.getTitle() != null){
            sujetToEdit.setTitle(sujet.getTitle());
        }
        if (sujet.getContent() != null){
            sujetToEdit.setContent(sujet.getContent());
        }
        if (sujet.getCreatedBy() != null)
            sujetToEdit.setCreatedBy(sujet.getCreatedBy());
        return this.sujetRepo.saveAndFlush(sujetToEdit);

    }

    @Override
    public void delete(Integer sujetId) {
        this.sujetRepo.deleteById(sujetId);

    }
}
