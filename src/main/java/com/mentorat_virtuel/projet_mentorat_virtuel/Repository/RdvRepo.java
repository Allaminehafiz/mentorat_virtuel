package com.mentorat_virtuel.projet_mentorat_virtuel.Repository;

import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.RDV;
import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.Thematique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RdvRepo extends JpaRepository<RDV,Integer> {


}
