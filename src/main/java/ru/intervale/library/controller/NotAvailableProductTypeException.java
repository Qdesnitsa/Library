package ru.intervale.library.controller;

public class NotAvailableProductTypeException extends Exception {
    public NotAvailableProductTypeException() {
        super();
    }
    public NotAvailableProductTypeException(String message) {
        super(message);
    }
    public NotAvailableProductTypeException(Throwable cause) {
        super(cause);
    }
    public NotAvailableProductTypeException(String message, Throwable cause) {
        super(message, cause);
    }




}
