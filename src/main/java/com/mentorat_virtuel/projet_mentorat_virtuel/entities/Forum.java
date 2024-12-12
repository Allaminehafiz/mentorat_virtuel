package com.mentorat_virtuel.projet_mentorat_virtuel.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Forum {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer forumId;
    private String title;
    private String description;
    private Date createdBy;
    private Date createdAt;
}
