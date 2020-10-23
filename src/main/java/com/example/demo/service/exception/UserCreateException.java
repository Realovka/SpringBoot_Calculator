package com.example.demo.service.exception;

public class UserCreateException extends RuntimeException {
    public UserCreateException() {
        super();
    }

    public UserCreateException(String message) {
        super(message);
    }

    public UserCreateException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserCreateException(Throwable cause) {
        super(cause);
    }

    protected UserCreateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
