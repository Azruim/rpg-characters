package exceptions;

public class InvalidWeaponException extends RuntimeException {
    public InvalidWeaponException(String errorMessage) {
        super(errorMessage);
    }
}
