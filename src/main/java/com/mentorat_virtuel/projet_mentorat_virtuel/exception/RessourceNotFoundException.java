package com.mentorat_virtuel.projet_mentorat_virtuel.exception;

public class RessourceNotFoundException extends RuntimeException{
    public RessourceNotFoundException(String message) {
        super(message);
    }
}