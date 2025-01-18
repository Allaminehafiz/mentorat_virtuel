package com.mentorat_virtuel.projet_mentorat_virtuel.repository;

import com.mentorat_virtuel.projet_mentorat_virtuel.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategorieRepo extends JpaRepository<Categorie,Integer> {

    Optional<Categorie> findByNom(String nom);


}
