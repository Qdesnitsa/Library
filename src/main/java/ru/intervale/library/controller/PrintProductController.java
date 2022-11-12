package ru.intervale.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.intervale.library.model.PrintProduct;
import ru.intervale.library.service.PrintProductService;
import ru.intervale.library.service.exception.NotAvailableProductTypeException;
import ru.intervale.library.util.AppConstant;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class PrintProductController {
    @Autowired
    PrintProductService productService;

    @GetMapping
    public ResponseEntity<List<PrintProduct>> getAllPrintProducts(
            @RequestParam(value = "type", defaultValue = AppConstant.DEFAULT_TYPE, required = false) String type,
            @RequestParam(value = "name", defaultValue = AppConstant.DEFAULT_NAME, required = false) String name,
            @RequestParam(value = "author", defaultValue = AppConstant.DEFAULT_AUTHOR, required = false) String author,
            @RequestParam(value = "date", defaultValue = AppConstant.DEFAULT_DATE, required = false) String date,
            @RequestParam(value = "genre", defaultValue = AppConstant.DEFAULT_GENRE, required = false) String genre
    ) {
        List<PrintProduct> printProducts = productService.findAllPrintProducts(type.toUpperCase(),
                name, author, date, genre.toUpperCase());
        return new ResponseEntity<>(printProducts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrintProduct> getPrintProductById(@PathVariable("id") Long id) {
        PrintProduct printProduct = productService.findPrintProductById(id);
        return new ResponseEntity<>(printProduct, HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<PrintProduct> createPrintProduct(@RequestBody @Valid PrintProduct printProduct) {
        PrintProduct targetProduct = productService.createPrintProduct(printProduct);
        return new ResponseEntity<>(targetProduct, HttpStatus.CREATED);
    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    public ResponseEntity<PrintProduct> partialUpdatePrintProduct(
            @PathVariable("id") Long id,
            @RequestBody @Valid PrintProduct printProduct) throws NotAvailableProductTypeException {
        PrintProduct targetProduct = productService.partialUpdatePrintProduct(id, printProduct);
        return new ResponseEntity<>(targetProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PrintProduct> delete(@PathVariable Long id) {
        productService.deletePrintProductById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
