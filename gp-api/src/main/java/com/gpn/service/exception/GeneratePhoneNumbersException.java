package com.gpn.service.exception;  

public class GeneratePhoneNumbersException extends RuntimeException{

	private final String messageKey;
	private static final long serialVersionUID = -6947877709460374908L;
	
    public GeneratePhoneNumbersException(String messageKey,String message) {
		super(message);
		this.messageKey=messageKey;
	}

	
	public GeneratePhoneNumbersException(String messageKey,String message, Throwable cause) {
		super(message,cause);
		this.messageKey=messageKey;
	}

	public String getMessageKey() {
		return messageKey;
	}
}