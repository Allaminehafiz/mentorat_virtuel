package com.mentorat_virtuel.projet_mentorat_virtuel.exception;


import com.mentorat_virtuel.projet_mentorat_virtuel.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(ResourceExisteException.class)
    public ResponseEntity<ErrorMessage> resourceExisteException(Exception e){
        return ResponseEntity.status(404).body(new ErrorMessage(404, e.getMessage(), HttpStatus.BAD_REQUEST.getReasonPhrase(), new Date()));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage>  resourceNotFoundException(Exception e){

        return ResponseEntity.status(400).body(new ErrorMessage(404, e.getMessage(), HttpStatus.NOT_FOUND.getReasonPhrase(), new Date()));
    }

}
