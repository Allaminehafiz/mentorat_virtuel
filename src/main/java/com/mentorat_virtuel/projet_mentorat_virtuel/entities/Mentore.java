package com.mentorat_virtuel.projet_mentorat_virtuel.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Mentores")
public class Mentore implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mentoreId;
    @Column(nullable = false)
    private String firstname ;
    private String lastname;
    private String email;
    private String phone;
    private String Objective ;
    @Temporal(TemporalType.TIME)
    private Date createdAt;
    @Temporal(TemporalType.TIME)
    private Date updatedAt;
    private Boolean status;

    @OneToOne
    LocationMentore locationMentores;

    public Mentore() {
    }

    public Integer getMentoreId() {
        return mentoreId;
    }

    public void setMentoreId(Integer mentoreId) {
        this.mentoreId = mentoreId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getObjective() {
        return Objective;
    }

    public void setObjective(String objective) {
        Objective = objective;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocationMentore getLocationMentores() {
        return locationMentores;
    }

    public void setLocationMentores(LocationMentore locationMentores) {
        this.locationMentores = locationMentores;
    }

    public Mentore(Integer mentoreId, String firstname, String lastname, String email, String phone, String objective, Date createdAt, Date updatedAt, Boolean status, LocationMentore locationMentores) {
        this.mentoreId = mentoreId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        Objective = objective;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
        this.locationMentores = locationMentores;


    }
}
