package com.mentorat_virtuel.projet_mentorat_virtuel.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Commentaires")
public class Commentaire implements Serializable {
    @Serial
    private static final long serialVersionUID =1L;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;
    private String content;
    private Integer sujetId;
    private String createdBy;
    private Date createdAt;

    @ManyToMany
    private List<Sujet> sujets = new ArrayList<>();
}
