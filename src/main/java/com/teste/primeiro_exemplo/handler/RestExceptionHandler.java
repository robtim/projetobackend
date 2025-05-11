package com.teste.primeiro_exemplo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.teste.primeiro_exemplo.model.error.ErrorMessage;
import com.teste.primeiro_exemplo.model.exception.ResourceNotFoudException;

@ControllerAdvice
public class RestExceptionHandler {
    
    @ExceptionHandler
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoudException ex){
         
        ErrorMessage error = new ErrorMessage("Not Found", HttpStatus.NOT_FOUND.value(), ex.getMessage());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

}
