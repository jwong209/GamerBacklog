package com.techelevator.exception;

public class BacklogServiceException extends RuntimeException{

    public BacklogServiceException() {
        super();
    }
    public BacklogServiceException(String message) {
        super(message);
    }
    public BacklogServiceException(String message, Exception cause) {
        super(message, cause);
    }

}
