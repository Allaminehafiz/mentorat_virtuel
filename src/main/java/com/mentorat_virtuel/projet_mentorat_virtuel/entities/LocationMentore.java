package com.mentorat_virtuel.projet_mentorat_virtuel.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Locations")
public class LocationMentore implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer LocationMentoreID;
    private Integer postalCode;
    private String street ;
    private String town ;
    @Temporal(TemporalType.TIME)
    private Date createdAt;
    @Temporal(TemporalType.TIME)
    private Date updatedAt;
    private Boolean status;

    @OneToOne
    Mentore mentore;

    public LocationMentore() {

    }

    public LocationMentore(Integer locationMentoreID, Integer postalCode, String street, String town, Date createdAt, Date updatedAt, Boolean status) {
        LocationMentoreID = locationMentoreID;
        this.postalCode = postalCode;
        this.street = street;
        this.town = town;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }

    public Integer getLocationMentoreID() {
        return LocationMentoreID;
    }

    public void setLocationMentoreID(Integer locationMentoreID) {
        LocationMentoreID = locationMentoreID;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
