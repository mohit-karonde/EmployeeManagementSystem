package com.example.demo.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.demo.payload.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	
	
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponse> runtimeExceptionHandler(RuntimeException ex) {
	    ErrorResponse response = new ErrorResponse(
	        "Internal error",
	        ex.getMessage(),
	        "employeeNotFound"
	    );

	    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
