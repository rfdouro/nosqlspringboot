package br.org.testes.exnitrite.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler
  extends ResponseEntityExceptionHandler {

 @ExceptionHandler(value = { Exception.class })
 protected ResponseEntity<Object> handleConflict(
   RuntimeException ex, WebRequest request) {
  String bodyOfResponse = "{\"erro\": \"" + ex.getMessage() + "\"}";
  return handleExceptionInternal(ex, bodyOfResponse,
    new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
 }
}
