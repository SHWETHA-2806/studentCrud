package com.example.democrudprojecttwo.error;

public class StudentNotFoundException extends RuntimeException {

	public StudentNotFoundException(String message)
	{
		super(message);
	}
}
