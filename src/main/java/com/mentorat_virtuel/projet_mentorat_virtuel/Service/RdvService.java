package com.mentorat_virtuel.projet_mentorat_virtuel.Service;

import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.RDV;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.RdvReqDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.RdvRespDTO;

public interface RdvService {
    public RdvRespDTO addRdv(RdvReqDTO rdvReqDTO);
}
