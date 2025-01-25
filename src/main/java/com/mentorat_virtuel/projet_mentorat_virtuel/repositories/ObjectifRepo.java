package com.mentorat_virtuel.projet_mentorat_virtuel.repositories;

import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Objectif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ObjectifRepo extends JpaRepository<Objectif,Integer> {


}


