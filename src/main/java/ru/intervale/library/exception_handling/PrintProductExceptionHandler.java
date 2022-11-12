package ru.intervale.library.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.intervale.library.service.exception.NotAvailableProductTypeException;
import ru.intervale.library.service.exception.ObligatoryBookFieldException;
import ru.intervale.library.service.exception.ObligatoryMagazineFieldException;
import ru.intervale.library.service.exception.ObligatoryNewspaperFieldException;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class PrintProductExceptionHandler {
    private static final String NO_SUCH_ID = "There is no Print product with this ID in the database";
    private static final String INCORRECT_PRODUCT_TYPE = "Product type is incorrect";
    private static final String OBLIGATORY_BOOK_FIELDS = "Check author, genre, name values";
    private static final String OBLIGATORY_MAGAZINE_FIELDS = "Check type, genre and name values";
    private static final String OBLIGATORY_NEWSPAPER_FIELDS = "Check type, genre and name values";
    private static final String INCORRECT_ENUM = "Check Product type and Genre data";

    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity<ProductIncorrectData> handleNoSuchElementException() {
        ProductIncorrectData data = new ProductIncorrectData();
        data.setInfo(NO_SUCH_ID);
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NotAvailableProductTypeException.class})
    public ResponseEntity<ProductIncorrectData> handleNotAvailableProductTypeException() {
        ProductIncorrectData data = new ProductIncorrectData();
        data.setInfo(INCORRECT_PRODUCT_TYPE);
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ObligatoryBookFieldException.class})
    public ResponseEntity<ProductIncorrectData> handleObligatoryBookFieldException() {
        ProductIncorrectData data = new ProductIncorrectData();
        data.setInfo(OBLIGATORY_BOOK_FIELDS);
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ObligatoryMagazineFieldException.class})
    public ResponseEntity<ProductIncorrectData> handleObligatoryMagazineFieldException() {
        ProductIncorrectData data = new ProductIncorrectData();
        data.setInfo(OBLIGATORY_MAGAZINE_FIELDS);
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ObligatoryNewspaperFieldException.class})
    public ResponseEntity<ProductIncorrectData> handleObligatoryNewspaperFieldException() {
        ProductIncorrectData data = new ProductIncorrectData();
        data.setInfo(OBLIGATORY_NEWSPAPER_FIELDS);
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResponseEntity<ProductIncorrectData> handleNotAvailableProductTypeExceptionException() {
        ProductIncorrectData data = new ProductIncorrectData();
        data.setInfo(INCORRECT_ENUM);
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ProductIncorrectData> handleException(Exception exception) {
        ProductIncorrectData data = new ProductIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
