package com.ngsb.exeption.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ngsb.dto.Message;
import com.ngsb.exeption.ProductNotFoundException;

@RestControllerAdvice
public class ProductExceptionHandler {
	
	/*
	 NOTE : WHILE WORKING WITH SECURITY DO NOT HANDLE Exception.class as
	  		Global Exception Handler, because if we do the same then 
	  		AuthenticationEntryPoint is not triggered.
	*/			  
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<Message> handleProductNotFoundEx(ProductNotFoundException pnfe){
		return new ResponseEntity<>(new Message("Failed", pnfe.getMessage()),HttpStatus.BAD_REQUEST);
	}
	
}

