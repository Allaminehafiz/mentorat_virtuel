package com.mentorat_virtuel.projet_mentorat_virtuel.Service;

import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.RDV;
import com.mentorat_virtuel.projet_mentorat_virtuel.Exception.ResourceNotFoundException;
import com.mentorat_virtuel.projet_mentorat_virtuel.Repository.RDVRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RDVServiceImp  implements RDVService{
   public RDVRepo rdvRepo;

    public RDVServiceImp(RDVRepo rdvRepo) {
        this.rdvRepo = rdvRepo;
    }

    @Override
    public RDV addRDV(RDV rdv) {
        return this.rdvRepo.save(rdv);
    }

    @Override
    public Page<RDV> getRDV(Page<RDV>  pageable) {
        return this.rdvRepo.findAll((Pageable) pageable);
    }

    @Override
    public RDV getRDVById(Integer rdvId) {
        return this.rdvRepo.findById(rdvId).orElseThrow(() -> new ResourceNotFoundException("Rendez-vous with ID not found!" ));
    }

    @Override
    public RDV updatedRDVById(RDV rdv, Integer rdvId) {
        RDV RDVToEdit= this.rdvRepo.findById(rdvId).get();
        RDVToEdit.setDebutduRDV(rdv.getDebutduRDV());
        RDVToEdit.setEtat(rdv.getEtat());
        RDVToEdit.setDuree(rdv.getDuree());
        RDVToEdit.setVisioconference(rdv.getVisioconference());
        return this.rdvRepo.saveAndFlush(RDVToEdit);
    }

    @Override
    public void deleteRDV(Integer rdvId) {

    }
}
