package com.example.democrudprojecttwo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.democrudprojecttwo.model.ErrorMessage;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(StudentNotFoundException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessage employeeNotFoundHandler(StudentNotFoundException exception)
	{
		ErrorMessage message =new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
		return message;
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorMessage genericExceptionHandler (Exception exception)
	{
		ErrorMessage message= new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
		return message;
	}
	
}
