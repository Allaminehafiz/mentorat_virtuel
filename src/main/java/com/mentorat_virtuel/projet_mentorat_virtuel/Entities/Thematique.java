package com.mentorat_virtuel.projet_mentorat_virtuel.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Table
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Thematique {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Length(min = 3,max = 50,message = "libelle must have atleast 3 characters and at most 50 characters")
    private String libelle;
    //association
    @OneToOne
    private RDV rdv;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle ( String libelle) {
        this.libelle = libelle;
    }

    public RDV getRdv() {
        return rdv;
    }

    public void setRdv(RDV rdv) {
        this.rdv = rdv;
    }
}
