package com.mentorat_virtuel.projet_mentorat_virtuel.Exception;


public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}