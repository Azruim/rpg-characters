package com.assignment1;

public class InvalidArmorException extends RuntimeException {
    public InvalidArmorException(String errorMessage) {
        super(errorMessage + "\n");
    }
}
