package com.ecom.productservice.exceptions;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionalHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handlesProductNotFoundException(ProductNotFoundException ex)
    {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
            "status" ,404,
            "TimeStamp" ,LocalDateTime.now(),
            "Message " ,ex.getMessage()
        ));
    }
    
}
