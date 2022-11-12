package ru.intervale.library.service.exception;

public class ObligatoryFieldException extends Exception {
    public ObligatoryFieldException() {
        super();
    }
    public ObligatoryFieldException(String message) {
        super(message);
    }
    public ObligatoryFieldException(Throwable cause) {
        super(cause);
    }
    public ObligatoryFieldException(String message, Throwable cause) {
        super(message, cause);
    }
}
