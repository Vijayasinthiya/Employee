package com.example.employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class GlobalExceptionHandling {
	@ExceptionHandler(value = NameNotFoundException.class)
	public ResponseEntity<Object> nameNotExceptionHandling(NameNotFoundException ne) {
		return new ResponseEntity<>(ne.getMessage(), HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = GenderException.class)
	public ResponseEntity<Object> gendernotFound(GenderException ge) {
		return new ResponseEntity<>(ge.getMessage(), HttpStatus.NOT_FOUND);
	}
@ExceptionHandler(value=AgeException.class)
public ResponseEntity<Object> ageNotFound(AgeException ae){
	return new ResponseEntity<> (ae.getMessage(),HttpStatus.NOT_FOUND);
}
}
