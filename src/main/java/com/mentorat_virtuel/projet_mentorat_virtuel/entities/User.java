package com.mentorat_virtuel.projet_mentorat_virtuel.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Users")
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String firstname;
    private String lastname;
    private String email;
    private String role;
    private Integer phone;

    @OneToMany(mappedBy = "User")
    private List<Forum> forums = new ArrayList<>();

}
