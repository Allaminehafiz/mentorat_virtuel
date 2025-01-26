package com.mentorat_virtuel.projet_mentorat_virtuel.Repository;

import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.FeedBack;
import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.Thematique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ThematiqueRepo extends JpaRepository<Thematique,Integer> {
    @Query("select t from Thematique t where t.libelle = :" +
            "libelle")
    Optional<Thematique> findThematiqueByLibelle(@Param("libelle") String libelle);
}

