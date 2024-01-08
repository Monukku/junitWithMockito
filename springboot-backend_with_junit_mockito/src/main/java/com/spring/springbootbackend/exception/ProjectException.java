package com.spring.springbootbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProjectException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProjectException(String message) {
		super(message);

	}

}
