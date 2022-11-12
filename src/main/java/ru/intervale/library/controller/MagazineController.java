package ru.intervale.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.intervale.library.model.PrintProduct;
import ru.intervale.library.service.MagazineService;
import ru.intervale.library.service.exception.NotAvailableProductTypeException;
import ru.intervale.library.service.exception.ObligatoryMagazineFieldException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/products/magazines")
public class MagazineController {
    @Autowired
    MagazineService magazineService;

    @GetMapping("/all")
    public ResponseEntity<List<PrintProduct>> getAllMagazines() {
        List<PrintProduct> magazines = magazineService.findAllMagazines();
        return new ResponseEntity<>(magazines, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrintProduct> getMagazineById(@PathVariable("id") Long id) {
        PrintProduct magazine = magazineService.findMagazineById(id);
        return new ResponseEntity<>(magazine, HttpStatus.OK);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<PrintProduct>> getMagazinesByDate(@PathVariable("date") String date) {
        List<PrintProduct> magazines = magazineService.findMagazinesByDate(date);
        return new ResponseEntity<>(magazines, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<PrintProduct>> getMagazinesByName(@PathVariable("name") String name) {
        List<PrintProduct> magazines = magazineService.findMagazinesByName(name);
        return new ResponseEntity<>(magazines, HttpStatus.OK);
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<PrintProduct>> getMagazinesByGenre(@PathVariable("genre") String genre) {
        List<PrintProduct> magazines = magazineService.findMagazinesByGenre(genre);
        return new ResponseEntity<>(magazines, HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<PrintProduct> createMagazine(@RequestBody @Valid PrintProduct printProduct) throws ObligatoryMagazineFieldException {
        PrintProduct magazine = magazineService.createMagazine(printProduct);
        return new ResponseEntity<>(magazine, HttpStatus.CREATED);
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity<PrintProduct> updateMagazine(@RequestBody @Valid PrintProduct printProduct) {
        PrintProduct magazine = magazineService.updateMagazine(printProduct);
        return new ResponseEntity<>(magazine, HttpStatus.OK);
    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    public ResponseEntity<PrintProduct> partialUpdateMagazine(
            @PathVariable("id") Long id,
            @RequestBody @Valid PrintProduct printProduct) throws NotAvailableProductTypeException {
        PrintProduct magazine = magazineService.partialUpdateMagazine(id, printProduct);
        return new ResponseEntity<>(magazine, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PrintProduct> deleteMagazine(@PathVariable Long id) {
        magazineService.deleteMagazineById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
