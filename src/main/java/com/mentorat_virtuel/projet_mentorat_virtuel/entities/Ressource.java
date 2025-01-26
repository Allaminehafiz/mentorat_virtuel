package com.mentorat_virtuel.projet_mentorat_virtuel.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "ressources")
public class Ressource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idRessource;
    private String description;
    private Double prix;
    private Date creatAt;
    private Date UpdateAt;
    private Boolean etat;

    public Ressource() {
    }

    public Ressource(String idRessource, String description, Double prix, Date creatAt, Date updateAt, Boolean etat) {
        this.idRessource = idRessource;
        this.description = description;
        this.prix = prix;
        this.creatAt = creatAt;
        UpdateAt = updateAt;
        this.etat = etat;

    }

    public String getIdRessource() {
        return idRessource;
    }

    public void setIdRessource(String idRessource) {
        this.idRessource = idRessource;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Date getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(Date creatAt) {
        this.creatAt = creatAt;
    }

    public Boolean getEtat() {
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }

    public Date getUpdateAt() {
        return UpdateAt;
    }

    public void setUpdateAt(Date updateAt) {
        UpdateAt = updateAt;
    }

    /*@OneToMany (mappedBy = "Ressource",
            cascade = CascadeType.ALL,
            fetch = FetchType. EAGER,
            orphanRemoval = true)
    private Set<Category> categories=
            new HashSet<>();*/



}
