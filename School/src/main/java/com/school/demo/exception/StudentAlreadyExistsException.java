package com.school.demo.exception;

public class StudentAlreadyExistsException extends RuntimeException {

    private String message;

    public StudentAlreadyExistsException() {}

    public StudentAlreadyExistsException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}
