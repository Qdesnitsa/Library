package ru.intervale.library.aop.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.intervale.library.service.exception.NotAvailableProductTypeException;

@RestControllerAdvice
public class PrintProductExceptionHandler {
    @ExceptionHandler({NotAvailableProductTypeException.class, HttpMessageNotReadableException.class})
    public ResponseEntity<ProductIncorrectData> handleException(Exception exception) {
        ProductIncorrectData data = new ProductIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

}
