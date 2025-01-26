package com.mentorat_virtuel.projet_mentorat_virtuel.Service;

import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.EtatRdv;
import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.RDV;
import com.mentorat_virtuel.projet_mentorat_virtuel.Exception.ResourceFoundException;
import com.mentorat_virtuel.projet_mentorat_virtuel.Exception.ResourceNotFoundException;
import com.mentorat_virtuel.projet_mentorat_virtuel.Repository.RdvRepo;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.RdvReqDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.RdvRespDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.mapper.RdvMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RdvServiceImpl implements RdvService {
    public final RdvRepo rdvRepo;
    private final RdvMapper rdvMapper;

    public RdvServiceImpl(RdvRepo rdvRepo, RdvMapper rdvMapper) {
        this.rdvRepo = rdvRepo;
        this.rdvMapper = rdvMapper;
    }

    @Override
    public RDV addRdv(RDV rdv) {
    return this.rdvRepo.save(rdv);
    }

    @Override
    public List<RDV> getAll() {
        return List.of();
    }


    @Override
    public RDV getRDVById(Integer rdvId) {
        return this.rdvRepo.findById(rdvId).orElseThrow(()-> new ResourceNotFoundException("rdv does not exist"));
    }

    @Override
    public RDV updatedRDV(RDV rdv, Integer rdvId) {
        Optional<RDV> rdvToEdit= this.rdvRepo.findById(rdvId);
        if (rdvToEdit.isEmpty())
            throw new ResourceNotFoundException("rdv does not exist");
        if (rdv.getDebutduRDV()!=null)
            rdvToEdit.get().setDebutduRDV(rdv.getDebutduRDV());
        if (rdv.getDuree()!=null)
            rdvToEdit.get().setDuree(rdv.getDuree());
        if (rdv.getEtat()!=null)
            rdvToEdit.get().setEtat(rdv.getEtat());
        if (rdv.getVisioconference()!=null)
            rdvToEdit.get().setVisioconference(rdv.getVisioconference());
        return this.rdvRepo.saveAndFlush(rdvToEdit.get());
    }

    @Override
    public void deleteRDV(Integer rdvId) {
        RDV rdv= this.rdvRepo.findById(rdvId)
                .orElseThrow(()-> new ResourceNotFoundException("rdv does not exist"));
        this.rdvRepo.delete(rdv);
    }
}
