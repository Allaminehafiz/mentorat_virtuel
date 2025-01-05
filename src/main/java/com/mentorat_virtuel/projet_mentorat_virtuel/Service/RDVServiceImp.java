package com.mentorat_virtuel.projet_mentorat_virtuel.Service;

import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.RDV;
import com.mentorat_virtuel.projet_mentorat_virtuel.Exception.ResourceNotFoundException;
import com.mentorat_virtuel.projet_mentorat_virtuel.Repository.RDVRepo;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public List<RDV> getRDV() {
        return this.rdvRepo.findAll();
    }

    @Override
    public RDV getRDVById(Integer rdvId) {
        return this.rdvRepo.findById(rdvId).orElseThrow(() -> new ResourceNotFoundException("Rendez-vous with ID '" ));
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
