package com.acs560.cricket_analyzer.Exception;
import org.springframework.core.annotation.Order;

import java.util.NoSuchElementException;

import org.springframework.core.Ordered;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class PlayerException {
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNosuchElementException(){
		return ResponseEntity.badRequest().body("No match found");
	}
}
