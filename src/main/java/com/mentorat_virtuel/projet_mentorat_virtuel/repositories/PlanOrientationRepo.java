package com.mentorat_virtuel.projet_mentorat_virtuel.repositories;

import com.mentorat_virtuel.projet_mentorat_virtuel.entities.PlanOrientation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanOrientationRepo extends JpaRepository<PlanOrientation, Integer> {



}
