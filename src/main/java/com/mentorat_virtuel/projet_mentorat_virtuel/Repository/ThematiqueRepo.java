package com.mentorat_virtuel.projet_mentorat_virtuel.Repository;

import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.Thematique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThematiqueRepo extends JpaRepository<Thematique,Integer> {

}
