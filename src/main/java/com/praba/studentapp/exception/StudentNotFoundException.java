package com.praba.studentapp.exception;

@SuppressWarnings("serial")
public class StudentNotFoundException extends RuntimeException {

	public StudentNotFoundException(String message) {
		super(message);
	}
}
