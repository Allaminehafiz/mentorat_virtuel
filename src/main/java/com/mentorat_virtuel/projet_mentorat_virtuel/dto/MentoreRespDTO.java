package com.mentorat_virtuel.projet_mentorat_virtuel.dto;

public record MentoreRespDTO( String firstname,
                              String lastname,
                              String phone,
                              String email,
                              Boolean status,
                              LocationRespDTO locationRespDTO) {
}
