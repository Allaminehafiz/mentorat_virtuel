package com.mentorat_virtuel.projet_mentorat_virtuel.Entities;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.NotEmpty;


@Table
@Entity
public class FeedBack {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer feedbackId;
    private Integer note;
    @Column(nullable = false)
    @NotEmpty(message = "this field must not be left empty")
    private String commentaire;

    //association
    @ManyToOne
    private RDV rdv;

    public Integer getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }


    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }


}
