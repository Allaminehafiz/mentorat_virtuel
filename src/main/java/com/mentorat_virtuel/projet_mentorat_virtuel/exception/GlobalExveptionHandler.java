package com.mentorat_virtuel.projet_mentorat_virtuel.exception;

import com.mentorat_virtuel.projet_mentorat_virtuel.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class GlobalExveptionHandler {

    @ExceptionHandler(RessourceExisteException.class)
    public ResponseEntity<ErrorMessage> ressourceExisteException(Exception e){

        return ResponseEntity.status(404).body(new ErrorMessage(404, e.getMessage(), HttpStatus.BAD_REQUEST.getReasonPhrase(), new Date()));
    }

    @ExceptionHandler(RessourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> ressourceNotFoundException(Exception e){

        return ResponseEntity.status(404).body(new ErrorMessage(404, e.getMessage(), HttpStatus.NOT_FOUND.getReasonPhrase(), new Date()));
    }

}
