package com.mentorat_virtuel.projet_mentorat_virtuel.Exception;

import org.springdoc.api.ErrorMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> ressourceNotFoundExceptionHandler(Exception exception) {
        return ResponseEntity
                .status(404)
                .body(new ErrorMessage(
                        exception.getMessage()
                ));


    }

    @ExceptionHandler(ResourceFoundException.class)
    public ResponseEntity<ErrorMessage> ressourceExistExceptionHandler(Exception exception) {
        return ResponseEntity
                .status(400)
                .body(new ErrorMessage(
                        exception.getMessage()
                ));

}
}