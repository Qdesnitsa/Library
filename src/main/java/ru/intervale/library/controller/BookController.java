package ru.intervale.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.intervale.library.model.PrintProduct;
import ru.intervale.library.service.BookService;
import ru.intervale.library.service.exception.NotAvailableProductTypeException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/products/books")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/all")
    public ResponseEntity<List<PrintProduct>> getAllBooks() {
        List<PrintProduct> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrintProduct> getBookById(@PathVariable("id") Long id) {
        PrintProduct book = bookService.findBookById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<List<PrintProduct>> getBooksByAuthor(@PathVariable("author") String author) {
        List<PrintProduct> books = bookService.findBookByAuthor(author);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<PrintProduct>> getBooksByDate(@PathVariable("date") String date) {
        List<PrintProduct> books = bookService.findBookByDate(date);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<PrintProduct>> getBooksByName(@PathVariable("name") String name) {
        List<PrintProduct> books = bookService.findBookByName(name);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<PrintProduct> createBook(@RequestBody @Valid PrintProduct printProduct) {
        PrintProduct book = bookService.createBook(printProduct);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity<PrintProduct> updateBook(@RequestBody @Valid PrintProduct printProduct) {
        PrintProduct book = bookService.updateBook(printProduct);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    public ResponseEntity<PrintProduct> partialUpdatePrintProduct(
            @PathVariable("id") Long id,
            @RequestBody @Valid PrintProduct printProduct) throws NotAvailableProductTypeException {
        PrintProduct book = bookService.partialUpdateBook(id, printProduct);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PrintProduct> delete(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
