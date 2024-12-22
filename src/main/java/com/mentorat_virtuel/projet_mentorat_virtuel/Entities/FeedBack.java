package com.mentorat_virtuel.projet_mentorat_virtuel.Entities;

import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;

@Table
@Entity
public class FeedBack {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer feedbackId;
    private Integer note;
    private String commentaire;
   // private Integer rdvId;
    //private Integer mentoretId;
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

    public RDV getRdv() {
        return rdv;
    }

    public void setRdv(RDV rdv) {
        this.rdv = rdv;
    }
}
