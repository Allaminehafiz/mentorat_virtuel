package com.mentorat_virtuel.projet_mentorat_virtuel.Exception;

public class ResourceFoundException extends RuntimeException {
    public ResourceFoundException(String message) {
        super(message);
    }
    public ResourceFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
