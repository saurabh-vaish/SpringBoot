package com.app.controller.rest;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.exception.ApiError;
import com.app.exception.CustomerNotFoundException;
import com.app.exception.EmployeeNotFoundException;
import com.app.exception.ItemNotFoundException;
import com.app.exception.StudentNotFoundException;

@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(value = StudentNotFoundException.class)
	public ResponseEntity<?> noStudentFound()
	{
		ApiError api = new ApiError(400, "No Student Found", new Date());  // generating a proper message for exception
		
		return new ResponseEntity<ApiError>(api,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = ItemNotFoundException.class)
	public ResponseEntity<?> noItemFound()
	{
		ApiError api = new ApiError(400, "No Item Found", new Date());  // generating a proper message for exception
		
		return new ResponseEntity<ApiError>(api,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = EmployeeNotFoundException.class)
	public ResponseEntity<?> noEmployeeFound()
	{
		ApiError api = new ApiError(400, "No Employee Found", new Date());  // generating a proper message for exception
		
		return new ResponseEntity<ApiError>(api,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = CustomerNotFoundException.class)
	public ResponseEntity<?> noCustomerFound()
	{
		ApiError api = new ApiError(400, "No Customer Found", new Date());  // generating a proper message for exception
		
		return new ResponseEntity<ApiError>(api,HttpStatus.BAD_REQUEST);
	}
	
}
