package com.example.minibank.exception;

public class SameAccountTransferException extends RuntimeException{

	public SameAccountTransferException(String message) {
		
		super(message);
		
	}
	
}
