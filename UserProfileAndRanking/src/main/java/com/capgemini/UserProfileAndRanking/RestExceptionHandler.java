package com.capgemini.UserProfileAndRanking;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.capgemini.UserProfileAndRanking.exceptions.NoSuchUserException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ NoSuchUserException.class })
	public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {

		return new ResponseEntity<Object>("Sorry, there is no such user in our database.", new HttpHeaders(),
				HttpStatus.BAD_REQUEST);
	}

}
