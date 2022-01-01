package pl.camp.it.motorcycle.rent.excepions;

public class ValidationException extends RuntimeException {

    public ValidationException(String message) {
        super(message);
    }
}
