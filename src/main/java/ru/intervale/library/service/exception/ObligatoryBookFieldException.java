package ru.intervale.library.service.exception;

public class ObligatoryBookFieldException extends Exception {
    public ObligatoryBookFieldException() {
        super();
    }
    public ObligatoryBookFieldException(String message) {
        super(message);
    }
    public ObligatoryBookFieldException(Throwable cause) {
        super(cause);
    }
    public ObligatoryBookFieldException(String message, Throwable cause) {
        super(message, cause);
    }
}
