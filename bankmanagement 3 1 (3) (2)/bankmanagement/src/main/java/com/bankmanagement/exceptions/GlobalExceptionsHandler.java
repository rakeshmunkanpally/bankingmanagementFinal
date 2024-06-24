package com.bankmanagement.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bankmanagement.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionsHandler {

	@ExceptionHandler(MyException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(MyException exception){
		return new ResponseEntity<ApiResponse>(new ApiResponse(exception.getMessage(),false),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({DataIntegrityViolationException.class,InvalidDataAccessApiUsageException.class})
	public ResponseEntity<ApiResponse> dataIntegrityViolationExceptionHandler(InvalidDataAccessApiUsageException exception){
		return new ResponseEntity<ApiResponse>(new ApiResponse(exception.getMessage(),false),HttpStatus.NOT_FOUND);
	}
	
	
}
