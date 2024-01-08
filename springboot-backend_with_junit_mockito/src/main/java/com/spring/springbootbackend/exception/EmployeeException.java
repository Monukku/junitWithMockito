package com.spring.springbootbackend.exception;

import org.springframework.http.HttpStatus; 
import org.springframework.web.bind.annotation.ResponseStatus;

//creating custom exception class

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmployeeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmployeeException(String message) {
		super(message);
	}

}
