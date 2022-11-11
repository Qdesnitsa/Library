package ru.intervale.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.intervale.library.dao.PrintProductRepository;
import ru.intervale.library.model.PrintProduct;
import ru.intervale.library.model.Type;
import ru.intervale.library.service.exception.NotAvailableProductTypeException;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class PrintProductController {
    @Autowired
    PrintProductRepository printRepo;

    @GetMapping
    public ResponseEntity<List<PrintProduct>> getPrintProducts() {
        List<PrintProduct> printProducts = (List<PrintProduct>) printRepo.findAll();
        return new ResponseEntity<>(printProducts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrintProduct> getPrintProductById(@PathVariable("id") Long id) {
        PrintProduct printProduct = printRepo.findById(id).get();
        return new ResponseEntity<>(printProduct, HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<PrintProduct> createPrintProduct(@RequestBody @Valid PrintProduct printProduct) {
        PrintProduct targetProduct = printRepo.save(printProduct);
        return new ResponseEntity<>(targetProduct, HttpStatus.CREATED);
    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    public ResponseEntity<PrintProduct> partialUpdatePrintProduct(
            @PathVariable("id") Long id,
            @RequestBody @Valid PrintProduct printProduct) throws NotAvailableProductTypeException {
        PrintProduct targetProduct = printRepo.findById(id).get();

        if (printProduct.getType() != null) {
            boolean isAvailableType = Arrays.stream(Type.values())
                    .anyMatch(availType -> availType.equals(printProduct.getType()));
            if (isAvailableType) {
                targetProduct.setType(printProduct.getType());
            }
        } else {
            throw new NotAvailableProductTypeException("Product type is incorrect");
        }

        return new ResponseEntity<>(targetProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PrintProduct> delete(@PathVariable Long id) {
        printRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
