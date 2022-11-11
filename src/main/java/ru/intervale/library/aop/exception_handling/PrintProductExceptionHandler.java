package ru.intervale.library.aop.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PrintProductExceptionHandler {
    @ExceptionHandler({Exception.class})
    public ResponseEntity<ProductIncorrectData> handleException(Exception exception) {
        ProductIncorrectData data = new ProductIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
