/*package com.mentorat_virtuel.projet_mentorat_virtuel.exception;


import com.mentorat_virtuel.projet_mentorat_virtuel.exception.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RessourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> resourceNotFoundExceptionHandler(Exception e) {
        return ResponseEntity
                .status(404)
                .body(new ErrorMessage(404, e.getMessage(), HttpStatus.NOT_FOUND.getReasonPhrase(), new Date()));

    }

    @ExceptionHandler(RessourceExistException.class)
    public ResponseEntity<ErrorMessage> resourceExistExceptionHandler(Exception e) {
        return ResponseEntity
                .status(400)
                .body(new ErrorMessage(400, e.getMessage(), HttpStatus.BAD_REQUEST.getReasonPhrase(), new Date()));

    }
}
*/