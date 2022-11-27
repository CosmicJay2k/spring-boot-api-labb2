package com.example.labb2.exception;

public class CustomException extends RuntimeException {

    private String message;

    public CustomException(String message) {
        this.message = message;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
