package com.mentorat_virtuel.projet_mentorat_virtuel.controllers;

import com.mentorat_virtuel.projet_mentorat_virtuel.entities.PlanOrientation;
import com.mentorat_virtuel.projet_mentorat_virtuel.services.PlanOrientationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/planOrientations")
public class PlanOrientationController {
   @Autowired(required = true)
    private PlanOrientationService planOrientationService;

    @GetMapping
    public List<PlanOrientation> getAllPlanOrientations() {
        return planOrientationService.getAllPlanOrientation();
    }
    @GetMapping("/{planId}")
    public Optional<PlanOrientation> getPlanOrientationById(@PathVariable int planId) {
        return this.planOrientationService.getPlanOrientationById(planId);
    }
    @PostMapping
    public PlanOrientation createPlanOrientation(@RequestBody PlanOrientation planOrientation) {

        return planOrientationService.addPlanOrientation(planOrientation);
    }
    @PutMapping
    public PlanOrientation updatePlanOrientation(@PathVariable int planId, @RequestBody PlanOrientation planOrientation) {

       return planOrientationService.updatePlanOrientation(planOrientation);
    }

@DeleteMapping("/{planId}")
    public void deletePlanOrientation(@PathVariable int planId) {
        planOrientationService.deletePlanOrientation(planId);
     }
    }