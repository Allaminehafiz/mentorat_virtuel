package com.mentorat_virtuel.projet_mentorat_virtuel.exception;

import com.mentorat_virtuel.projet_mentorat_virtuel.dto.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RessourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> ressourceNotFoundExceptionHandler(Exception exception){
        return ResponseEntity
                .status(404)
                .body(new ErrorMessage(
                        exception.getMessage(),
                        HttpStatus.NOT_FOUND.value(),
                        new Date(),
                        HttpStatus.NOT_FOUND.getReasonPhrase()
                ));
    }
    @ExceptionHandler(RessourceExistException.class)
    public ResponseEntity<ErrorMessage> ressourceExistExceptionHandler(Exception exception){
        return ResponseEntity
                .status(400)
                .body(new ErrorMessage(
                        exception.getMessage(),
                        HttpStatus.BAD_REQUEST.value(),
                        new Date(),
                        HttpStatus.BAD_REQUEST.getReasonPhrase()
                ));
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
