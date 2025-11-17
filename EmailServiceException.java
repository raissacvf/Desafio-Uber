package com.castro.email_service.core.exceptions;

public class EmailServiceException extends RuntimeException {
    public EmailServiceException(String message) {
        super(message);
    }   
    
    public EmailServiceException(String message, Throwable cause) {
        super(message, cause);
    }//definindo outro construtor que recebe a causa do erro

}
