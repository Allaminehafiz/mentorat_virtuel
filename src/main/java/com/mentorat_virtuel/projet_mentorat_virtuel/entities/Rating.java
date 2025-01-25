package com.mentorat_virtuel.projet_mentorat_virtuel.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // L'utilisateur qui donne la note

    @ManyToOne
    @JoinColumn(name = "commentsireId", nullable = false)
    private Commentaire commentaire; // Le produit noté (ou autre élément)

    private int score; // La note (par exemple, entre 1 et 5 étoiles)
    private String comment; // Commentaire optionnel
    @Temporal(TemporalType.TIME)
    private String createdAt; // Date de la notation
}

