package com.spring.springbootbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DependentException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DependentException(String message) {
		super(message);

	}

}
