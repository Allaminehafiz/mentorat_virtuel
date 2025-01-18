package com.mentorat_virtuel.projet_mentorat_virtuel.repository;

import com.mentorat_virtuel.projet_mentorat_virtuel.entity.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaireRepo extends JpaRepository<Commentaire,Integer> {
}
