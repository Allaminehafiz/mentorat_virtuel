package com.mentorat_virtuel.projet_mentorat_virtuel.service.Mentore;

import com.mentorat_virtuel.projet_mentorat_virtuel.Exception.ResourceNotFoundException;
import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Mentore;
import com.mentorat_virtuel.projet_mentorat_virtuel.repositories.MentoreRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MentoreServiceImpl implements MentoreService {
    private final MentoreRepo mentoreRepo;

    public MentoreServiceImpl(MentoreRepo mentoreRepo) {
        this.mentoreRepo = mentoreRepo;
    }

    @Override
    public Mentore addMentore(Mentore mentore) {
        mentore.setFirstname(mentore.getFirstname());
        mentore.setLastname(mentore.getLastname());
        mentore.setEmail(mentore.getEmail());
        mentore.setPhone(mentore.getPhone());
        mentore.setUpdatedAt(new Date());
        mentore.setStatus(true);
        return this.mentoreRepo.saveAndFlush(mentore) ;
    }

    @Override
    public List<Mentore> getMentore() {
        return this.mentoreRepo.findAll();

    }

    @Override
    public Mentore getMentoreById(Integer mentoreId) {

        return this.mentoreRepo.findById(mentoreId).orElseThrow(
                ()-> new ResourceNotFoundException("Mentoré not found !")
        );
    }

    @Override
    public Mentore getMentoreByEmail(String email) {
        return this.mentoreRepo.findByEmail(email).orElseThrow(
                ()-> new ResourceNotFoundException("Mentoré not found !")
        );
    }

    @Override
    public Mentore updateMentore(Mentore mentore, Integer mentoreId) {

        //Rechercher le client
        Optional<Mentore> mentoreToEdit = this.mentoreRepo.findById(mentoreId);
        if(mentoreToEdit.isEmpty())
            throw new ResourceNotFoundException("Mentoré not found !");
        //Modidier les informations du clients
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
                .orElseThrow(()->new ResourceNotFoundException("Mentoré not found"));
        this.mentoreRepo.delete(mentore);
    }
}
