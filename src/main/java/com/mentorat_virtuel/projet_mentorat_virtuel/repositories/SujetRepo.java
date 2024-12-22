package com.mentorat_virtuel.projet_mentorat_virtuel.repositories;

import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Sujet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SujetRepo extends JpaRepository<Sujet, Integer> {
}
