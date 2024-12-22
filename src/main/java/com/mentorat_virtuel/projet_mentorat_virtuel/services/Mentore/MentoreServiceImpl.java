package com.mentorat_virtuel.projet_mentorat_virtuel.services.Mentore;

import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Mentore;
import com.mentorat_virtuel.projet_mentorat_virtuel.exception.ResourceNotFoundException;
import com.mentorat_virtuel.projet_mentorat_virtuel.repositories.MentoreRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MentoreServiceImpl implements MentoreService{
    final MentoreRepo mentoreRepo;

    public MentoreServiceImpl(MentoreRepo mentoreRepo) {
        this.mentoreRepo = mentoreRepo;
    }

    @Override
    public Mentore addMentore(Mentore mentore) {
        mentore.setCreatedAt(new Date());
        mentore.setStatus(true);
        return this.mentoreRepo.save(mentore);
    }

    @Override
    public List<Mentore> getMentores() {
        return this.mentoreRepo.findAll();
    }

    @Override
    public Mentore getMentoreById(Integer mentoreId) {
        return this.mentoreRepo.findById(mentoreId).orElseThrow(
                ()-> new ResourceNotFoundException("Mentore not found !")
        );
    }

    @Override
    public Mentore getMentoreByEmail(String email) {
        return this.mentoreRepo.fetchByEmail(email)
                .orElseThrow(()->new ResourceNotFoundException("Mentore not found !"));
    }

    @Override
    public Mentore updateMentore(Mentore mentore, Integer mentoreId) {
        //Rechercher
        Optional<Mentore> mentoreToEdit = this.mentoreRepo.findById(mentoreId);
        if(mentoreToEdit.isEmpty())
            throw new ResourceNotFoundException("Mentore not found !");
        //Modidier les informations
        if(mentore.getFirstname()!=null)
            mentoreToEdit.get().setFirstname(mentore.getFirstname());
        if(mentore.getLastname()!=null)
            mentoreToEdit.get().setLastname(mentore.getLastname());
        if(mentore.getPhone()!=null)
            mentoreToEdit.get().setPhone(mentore.getPhone());
        if(mentore.getEmail()!=null)
            mentoreToEdit.get().setEmail(mentore.getEmail());
        mentoreToEdit.get().setUpdatedAt(new Date());
        //Sauvegarder les modifications
        return this.mentoreRepo.saveAndFlush(mentoreToEdit.get());
    }

    @Override
    public void deleteMentore(Integer mentoreId) {
        Mentore mentore = this.mentoreRepo.findById(mentoreId)
                .orElseThrow(()->new ResourceNotFoundException("Mentore not found"));
        this.mentoreRepo.delete(mentore);
    }
}

