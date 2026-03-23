package com.example.userService.exception;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    

    @ExceptionHandler
    public ResponseEntity<Map<String,Object>> handleUserNotFound(UserNotFoundExistException ex )
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
         "timestamp",LocalDateTime.now(),
         "status",404,
         "error","Not Found",
         "message",ex.getMessage()
        ));
    }
}
