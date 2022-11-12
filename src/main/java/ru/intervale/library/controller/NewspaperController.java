package ru.intervale.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.intervale.library.model.PrintProduct;
import ru.intervale.library.service.NewspaperService;
import ru.intervale.library.service.exception.NotAvailableProductTypeException;
import ru.intervale.library.service.exception.ObligatoryNewspaperFieldException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/products/newspapers")
public class NewspaperController {
    @Autowired
    NewspaperService newspaperService;

    @GetMapping("/all")
    public ResponseEntity<List<PrintProduct>> getAllNewspapers() {
        List<PrintProduct> newspapers = newspaperService.findAllNewspapers();
        return new ResponseEntity<>(newspapers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrintProduct> getNewspaperById(@PathVariable("id") Long id) {
        PrintProduct newspaper = newspaperService.findNewspaperById(id);
        return new ResponseEntity<>(newspaper, HttpStatus.OK);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<PrintProduct>> getNewspapersByDate(@PathVariable("date") String date) {
        List<PrintProduct> newspapers = newspaperService.findNewspapersByDate(date);
        return new ResponseEntity<>(newspapers, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<PrintProduct>> getNewspapersByName(@PathVariable("name") String name) {
        List<PrintProduct> newspapers = newspaperService.findNewspapersByName(name);
        return new ResponseEntity<>(newspapers, HttpStatus.OK);
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<PrintProduct>> getNewspapersByGenre(@PathVariable("genre") String genre) {
        List<PrintProduct> newspapers = newspaperService.findNewspapersByGenre(genre);
        return new ResponseEntity<>(newspapers, HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<PrintProduct> createNewspaper(@RequestBody @Valid PrintProduct printProduct) throws ObligatoryNewspaperFieldException {
        PrintProduct newspaper = newspaperService.createNewspaper(printProduct);
        return new ResponseEntity<>(newspaper, HttpStatus.CREATED);
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity<PrintProduct> updateNewspaper(@RequestBody @Valid PrintProduct printProduct) {
        PrintProduct newspaper = newspaperService.updateNewspaper(printProduct);
        return new ResponseEntity<>(newspaper, HttpStatus.OK);
    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    public ResponseEntity<PrintProduct> partialUpdateNewspaper(
            @PathVariable("id") Long id,
            @RequestBody @Valid PrintProduct printProduct) throws NotAvailableProductTypeException {
        PrintProduct newspaper = newspaperService.partialUpdateNewspaper(id, printProduct);
        return new ResponseEntity<>(newspaper, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PrintProduct> deleteNewspaper(@PathVariable Long id) {
        newspaperService.deleteNewspaperById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
