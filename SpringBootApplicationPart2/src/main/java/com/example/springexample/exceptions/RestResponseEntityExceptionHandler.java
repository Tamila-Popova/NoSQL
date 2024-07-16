package com.example.springexample.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<Object> handleNewsNotFoundException(
            NotFoundException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("message", bodyOfResponse);
        return new ResponseEntity<>(responseBody, HttpStatus.NOT_FOUND);
    }
}