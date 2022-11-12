package ru.intervale.library.service.exception;

public class ObligatoryNewspaperFieldException extends Exception {
    public ObligatoryNewspaperFieldException() {
        super();
    }
    public ObligatoryNewspaperFieldException(String message) {
        super(message);
    }
    public ObligatoryNewspaperFieldException(Throwable cause) {
        super(cause);
    }
    public ObligatoryNewspaperFieldException(String message, Throwable cause) {
        super(message, cause);
    }
}
