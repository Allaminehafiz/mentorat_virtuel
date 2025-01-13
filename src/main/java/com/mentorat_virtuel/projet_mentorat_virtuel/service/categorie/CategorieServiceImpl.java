package com.mentorat_virtuel.projet_mentorat_virtuel.service.categorie;

import com.mentorat_virtuel.projet_mentorat_virtuel.entity.Categorie;
import com.mentorat_virtuel.projet_mentorat_virtuel.exception.RessourceNotFoundException;
import com.mentorat_virtuel.projet_mentorat_virtuel.repository.CategorieRepo;
import com.mentorat_virtuel.projet_mentorat_virtuel.service.categorie.CategorieService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CategorieServiceImpl implements CategorieService {
    private final CategorieRepo categorieRepo;

    public CategorieServiceImpl(CategorieRepo categorieRepo) {
        this.categorieRepo = categorieRepo;
    }

    @Override
    public Categorie addCategorie(Categorie categorie) {

        return this.categorieRepo.save(categorie);
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
    public Categorie getCategorieByNom(String nom) {
      return this.categorieRepo.save(this.categorieRepo.findByNom(nom)
                .orElseThrow(()-> new RessourceNotFoundException("category doesn't exist!!")));

    }

    @Override
    public Categorie editCategorieStatus(Integer categorieId) {

        Categorie categorieToEdit = this.categorieRepo.findById(categorieId)
                .orElseThrow(()-> new RessourceNotFoundException("category not found!"));

        if(categorieToEdit.getStatus())
            categorieToEdit.setStatus(false);
        else
            categorieToEdit.setStatus(true);
        categorieToEdit.setDateModification(new Date());

        return this.categorieRepo.saveAndFlush(categorieToEdit);
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
