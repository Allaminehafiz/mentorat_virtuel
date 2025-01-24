package com.mentorat_virtuel.projet_mentorat_virtuel.Service;

import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.RDV;
import org.springframework.data.domain.Page;

public interface RDVService {
    RDV addRDV(RDV rdv);
    Page<RDV> getRDV(Page<RDV> pageable);
    RDV getRDVById(Integer rdvId);


    RDV updatedRDVById(RDV rdv, Integer rdvId);

    void deleteRDV(Integer rdvId);
}
