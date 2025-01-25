package com.mentorat_virtuel.projet_mentorat_virtuel.services;

import com.mentorat_virtuel.projet_mentorat_virtuel.entities.PlanOrientation;

import java.util.List;
import java.util.Optional;

public interface PlanOrientationService {
    PlanOrientation addPlanOrientation(PlanOrientation planOrientation);
    List<PlanOrientation> getAllPlanOrientation();
    Optional<PlanOrientation> getPlanOrientationById(int id);
    Void deletePlanOrientation(int id);
    PlanOrientation updatePlanOrientation(PlanOrientation planOrientation);

}
