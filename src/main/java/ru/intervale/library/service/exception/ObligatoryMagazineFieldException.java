package ru.intervale.library.service.exception;

public class ObligatoryMagazineFieldException extends Exception {
    public ObligatoryMagazineFieldException() {
        super();
    }
    public ObligatoryMagazineFieldException(String message) {
        super(message);
    }
    public ObligatoryMagazineFieldException(Throwable cause) {
        super(cause);
    }
    public ObligatoryMagazineFieldException(String message, Throwable cause) {
        super(message, cause);
    }
}
