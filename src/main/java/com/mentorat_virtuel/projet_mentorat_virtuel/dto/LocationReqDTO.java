package com.mentorat_virtuel.projet_mentorat_virtuel.dto;

import lombok.Data;

@Data
public class LocationReqDTO {
    private String town;
    private Integer postalCode;
    private String street;
}
