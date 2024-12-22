package com.mentorat_virtuel.projet_mentorat_virtuel.services.Mentore;

import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Mentore;

import java.util.List;

public interface MentoreService {
    Mentore addMentore(Mentore mentore);
    List<Mentore> getMentores();
    Mentore getMentoreById(Integer MentoreId);
    Mentore getMentoreByEmail(String email);
    Mentore updateMentore(Mentore mentore, Integer mentoreId);
    void deleteMentore(Integer mentoreId);
}
