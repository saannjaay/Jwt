package com.user.system.application.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.user.system.application.exception.ErrorDetails;
import com.user.system.application.exception.UserNotFoundException;

//GlobalExceptionHandler  is handle exception 

@ControllerAdvice
public class GlobalExceptionHandler {
	
	 @ExceptionHandler(UserNotFoundException.class)
	 public ResponseEntity<?> resourceNotFoundException(UserNotFoundException ex, WebRequest request) {
	  ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
	  return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	 }
	 @ExceptionHandler(Exception.class)
	 public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
	  ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
	  return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	 }

}
