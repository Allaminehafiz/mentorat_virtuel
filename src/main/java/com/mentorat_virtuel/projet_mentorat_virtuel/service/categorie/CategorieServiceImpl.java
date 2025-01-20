package com.mentorat_virtuel.projet_mentorat_virtuel.service.categorie;

import com.mentorat_virtuel.projet_mentorat_virtuel.dto.categorie.CategorieReqDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.categorie.CategorieRespDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.entity.Categorie;
import com.mentorat_virtuel.projet_mentorat_virtuel.exception.RessourceNotFoundException;
import com.mentorat_virtuel.projet_mentorat_virtuel.mapper.CategorieMapper;
import com.mentorat_virtuel.projet_mentorat_virtuel.repository.CategorieRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CategorieServiceImpl implements CategorieService {
    private final CategorieRepo categorieRepo;
    private final CategorieMapper categorieMapper;

    public CategorieServiceImpl(CategorieRepo categorieRepo, CategorieMapper categorieMapper) {
        this.categorieRepo = categorieRepo;
        this.categorieMapper = categorieMapper;
    }

    @Override
    public CategorieRespDTO addCategorie(CategorieReqDTO categorieReqDTO) {

        Categorie categorie = this.categorieMapper.fromCategorieReqDTO(categorieReqDTO);

        categorie = this.categorieRepo.save(categorie);

        return categorieMapper.fromCategorie(categorie);
    }

    @Override
    public List<Categorie> getAllCategorie() {

        return this.categorieRepo.findAll();}



    @Override
    public Categorie getCategorieById(Integer categorieId) {
        Optional<Categorie> categorie = this.categorieRepo.findById(categorieId);
        if (categorie.isEmpty())
            throw new RessourceNotFoundException("category not found!!");
        return categorie.get();
    }

    @Override
    public Page<CategorieRespDTO> pagination(int offset, int pageSize) {
        return this.categorieRepo.findAll(PageRequest.of(offset, pageSize, Sort.Direction.ASC,"dateCreation"))
                .map(categorie -> this.categorieMapper.fromCategorie(categorie));
    }

    @Override
    public List<Categorie> findCategorieByNomAndStatus(String nom, Boolean status) {
        Optional<Categorie> categorie = this.categorieRepo.findCategorieByNomAndStatus(nom,status);
        if (categorie.isEmpty())
            throw new RessourceNotFoundException("");
       return (List<Categorie>) categorie.get();

    }


    @Override
    public Categorie updateCategorie(Categorie categorie, Integer categorieId) {
        //search
        Optional<Categorie> categorieToEdit = this.categorieRepo.findById(categorieId);
        if (categorieToEdit.isEmpty())
            throw new RessourceNotFoundException("category not found!");
        //modification
        if (categorie.getNom()!=null)
            categorieToEdit.get().setNom(categorie.getNom());
        if (categorie.getDescription()!=null)
            categorieToEdit.get().setDescription(categorie.getDescription());
        categorieToEdit.get().setDateModification(new Date());
        //mettre a jour les nouvelles infos
        return this.categorieRepo.saveAndFlush(categorieToEdit.get());


    }

    @Override
    public void deleteCategorieById(Integer categorieId) {

        this.categorieRepo.delete(this.categorieRepo.findById(categorieId)
                .orElseThrow(()->new RessourceNotFoundException("category not found!")));
    }
}
