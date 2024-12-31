package com.mentorat_virtuel.projet_mentorat_virtuel.service.Mentore;

import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Mentore;

import java.util.List;

public interface MentoreService {

    Mentore addMentore(Mentore mentore);
    List<Mentore> getMentore();
    Mentore getMentoreById(Integer mentoreId);
    Mentore getMentoreByEmail(String email);
    Mentore updateMentore(Mentore mentore, Integer mentoreId);
    Mentore deleteMentore(Integer mentoreId);
}
