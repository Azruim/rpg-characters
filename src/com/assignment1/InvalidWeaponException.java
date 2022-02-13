package com.assignment1;

public class InvalidWeaponException extends RuntimeException {
    public InvalidWeaponException(String errorMessage) {
        super(errorMessage + "\n");
    }
}
