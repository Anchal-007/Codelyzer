package com.eduthrill.codelyser.Exception;

public class UserWithSameUserNameException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public UserWithSameUserNameException(String message){
        super(message);
    }

    public UserWithSameUserNameException(String message, Throwable throwable){
        super(message,throwable);
    }
}