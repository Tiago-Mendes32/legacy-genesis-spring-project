package com.legacy.model.controllers.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.legacy.model.services.exceptions.DocumentAlreadyExistsException;
import com.legacy.model.services.exceptions.EntityNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResponseExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<StandardError> genericException(Exception e, HttpServletRequest request) {
		
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		StandardError err = new StandardError(LocalDateTime.now(), status.value(), "Internal server error", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<StandardError> genericRuntimeException(RuntimeException e, HttpServletRequest request) {
		
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		StandardError err = new StandardError(LocalDateTime.now(), status.value(), "Internal server error", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(EntityNotFoundException e, HttpServletRequest request) {
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(LocalDateTime.now(), status.value(), "Object not found", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DocumentAlreadyExistsException.class)
	public ResponseEntity<StandardError> documentAlreadyExist(DocumentAlreadyExistsException e, HttpServletRequest request) {
		
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(LocalDateTime.now(), status.value(), "Document already exist", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
