package com.mentorat_virtuel.projet_mentorat_virtuel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
public record ErrorMessage(
        String message,
        Integer statusCode,
        Date timestamp,
        String error
) {
}
