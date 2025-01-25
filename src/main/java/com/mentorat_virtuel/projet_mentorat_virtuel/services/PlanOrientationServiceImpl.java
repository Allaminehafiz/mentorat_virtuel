package com.mentorat_virtuel.projet_mentorat_virtuel.services;

import com.mentorat_virtuel.projet_mentorat_virtuel.entities.PlanOrientation;
import com.mentorat_virtuel.projet_mentorat_virtuel.repositories.PlanOrientationRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanOrientationServiceImpl implements PlanOrientationService {

    private  PlanOrientationRepo planOrientationRepo;

    @Override
    public List<PlanOrientation> getAllPlanOrientation() {
        return planOrientationRepo.findAll();
    }

    @Override
    public Optional<PlanOrientation> getPlanOrientationById(int planId) {
        return planOrientationRepo.findById(planId);
    }
    @Override
    public PlanOrientation addPlanOrientation(PlanOrientation planOrientation) {

        return planOrientationRepo.save(planOrientation);
    }
    @Override
    public Void deletePlanOrientation(int planId) {
        planOrientationRepo.deleteById(planId);
        return null;
    }

    @Override
    public PlanOrientation updatePlanOrientation(PlanOrientation planOrientation) {

        return null;
   }
    }