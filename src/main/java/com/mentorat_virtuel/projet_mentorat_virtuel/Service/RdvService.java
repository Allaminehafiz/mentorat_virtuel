package com.mentorat_virtuel.projet_mentorat_virtuel.Service;

import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.RDV;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.RdvReqDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.RdvRespDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RdvService {
    public RDV addRdv(RDV rdv);
    List<RDV> getAll();
    RDV getRDVById(Integer rdvId);
    RDV updatedRDV(RDV rdv, Integer rdvId);
    void deleteRDV(Integer rdvId);
}

