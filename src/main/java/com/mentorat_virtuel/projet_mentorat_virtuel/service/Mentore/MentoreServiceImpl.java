package com.mentorat_virtuel.projet_mentorat_virtuel.service.Mentore;

import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Mentore;
import com.mentorat_virtuel.projet_mentorat_virtuel.repositories.MentoreRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
        return null;
    }

    @Override
    public Mentore getMentoreByEmail(String email) {
        return null;
    }

    @Override
    public Mentore updateMentore(Mentore mentore, Integer mentoreId) {
        return null;
    }

    @Override
    public Mentore deleteMentore(Integer mentoreId) {
        return null;
    }
}
