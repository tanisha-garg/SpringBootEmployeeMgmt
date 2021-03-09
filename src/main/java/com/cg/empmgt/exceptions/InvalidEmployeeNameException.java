package com.cg.empmgt.exceptions;

public class InvalidEmployeeNameException extends RuntimeException{
	
	public InvalidEmployeeNameException(String msg) {
		super(msg);
	}

}
