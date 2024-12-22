package com.mentorat_virtuel.projet_mentorat_virtuel.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
    private Integer commentaireId;

    private String content;
    private Integer sujetId;
    private String createdBy;
    private Date createdAt;

    @ManyToMany
    private List<Sujet> sujet = new ArrayList<>();

    public Integer getCommentaireId() {
        return commentaireId;
    }

    public void setCommentaireId(Integer commentaireId) {
        this.commentaireId = commentaireId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getSujetId() {
        return sujetId;
    }

    public void setSujetId(Integer sujetId) {
        this.sujetId = sujetId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<Sujet> getSujet() {
        return sujet;
    }

    public void setSujet(List<Sujet> sujet) {
        this.sujet = sujet;
    }
}
