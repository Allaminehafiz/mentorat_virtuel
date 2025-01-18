package com.mentorat_virtuel.projet_mentorat_virtuel.dto.categorie;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class CategorieReqDTO {
    @NotEmpty(message = "the field is required")
    @Length(min = 3, message = "the position name must have at least 3 characters")
    private String nom;
    @NotEmpty(message = "the field is required")
    private String description;
    private Boolean status;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date dateCreation;
}
