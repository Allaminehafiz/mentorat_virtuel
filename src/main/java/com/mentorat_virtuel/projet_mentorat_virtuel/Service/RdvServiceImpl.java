package com.mentorat_virtuel.projet_mentorat_virtuel.Service;

import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.RDV;
import com.mentorat_virtuel.projet_mentorat_virtuel.Repository.RdvRepo;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.RdvReqDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.RdvRespDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.mapper.RdvMapper;
import org.springframework.stereotype.Service;
@Service
public class RdvServiceImpl implements RdvService{
    public final RdvRepo rdvRepo;
    private final RdvMapper rdvMapper;

    public RdvServiceImpl(RdvRepo rdvRepo, RdvMapper rdvMapper) {
        this.rdvRepo = rdvRepo;
        this.rdvMapper = rdvMapper;
    }

    @Override
    public RdvRespDTO addRdv(RdvReqDTO rdvReqDTO) {
        RDV rdv = this.rdvMapper.fromRdvReqDTO(rdvReqDTO);
        rdv = this.rdvRepo.save(rdv);

        return rdvMapper.fromRdv(rdv);
    }
}
