package com.mentorat_virtuel.projet_mentorat_virtuel.Repository;

import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.RDV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RDVRepo extends JpaRepository<RDV, Integer> {
}
