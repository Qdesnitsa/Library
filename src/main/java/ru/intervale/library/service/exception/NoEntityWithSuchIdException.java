package ru.intervale.library.service.exception;

public class NoEntityWithSuchIdException extends Exception {
    public NoEntityWithSuchIdException() {
        super();
    }
    public NoEntityWithSuchIdException(String message) {
        super(message);
    }
    public NoEntityWithSuchIdException(Throwable cause) {
        super(cause);
    }
    public NoEntityWithSuchIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
