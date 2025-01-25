package com.mentorat_virtuel.projet_mentorat_virtuel.Repository;

import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.Mentor;
import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.RDV;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface RDVRepo extends JpaRepository<RDV, Integer> {
  // @Query("SELECT r FROM Rdv r WHERE r.debutDuRDV BETWEEN :startDate AND :endDate")
   // List<RDV> findBetweenDates(@Param("startDate") Instant startDate, @Param("endDate") Instant endDate);
  //  @Query("SELECT r FROM Rdv r WHERE r.mentor = :mentor")
    //List<RDV> findByMentor(@Param("mentor") Mentor mentor);
   // @Query("SELECT COUNT(r) FROM Rdv r WHERE r.etat = 'COMPLETED'")
    //Long countCompletedRdvs();
}

