package com.ngsb.exeption.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ngsb.dto.Message;

@RestControllerAdvice
public class UserExceptionHandler {
	
	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<Message> handleUsernameNotFoundEx(UsernameNotFoundException unfe) {
		return new ResponseEntity<>(new Message("Unauthorized", unfe.getMessage()),HttpStatus.UNAUTHORIZED);
	}
}
