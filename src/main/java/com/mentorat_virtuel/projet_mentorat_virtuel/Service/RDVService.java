package com.mentorat_virtuel.projet_mentorat_virtuel.Service;

import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.RDV;

import java.util.List;

public interface RDVService {
    RDV addRDV(RDV rdv);
    List<RDV> getRDV();
    RDV getRDVById(Integer rdvId);


    RDV updatedRDVById(RDV rdv, Integer rdvId);

    void deleteRDV(Integer rdvId);
}
