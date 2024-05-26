package com.techelevator.exception;

public class CollectionServiceException extends RuntimeException{

    public CollectionServiceException() {
        super();
    }
    public CollectionServiceException(String message) {
        super(message);
    }
    public CollectionServiceException(String message, Exception cause) {
        super(message, cause);
    }

}
