package com.mentorat_virtuel.projet_mentorat_virtuel.repositories;

import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaireRepo extends JpaRepository<Commentaire, Integer> {
}
