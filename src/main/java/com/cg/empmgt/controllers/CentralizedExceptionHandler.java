package com.cg.empmgt.controllers;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.cg.empmgt.exceptions.*;

@RestControllerAdvice
public class CentralizedExceptionHandler {
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(EmployeeNotFoundException.class)
	public String handleEmployeeNotFound(EmployeeNotFoundException e) {
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidEmployeeNameException.class)
	public String handleInvalidEmployeeName(InvalidEmployeeNameException e) {
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidDepartmentException.class)
	public String handleInvalidDepartmentName(InvalidDepartmentException e) {
		return e.getMessage();
	}

}
