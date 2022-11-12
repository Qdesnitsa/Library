package ru.intervale.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.intervale.library.dao.MagazineRepository;
import ru.intervale.library.model.PrintProduct;
import ru.intervale.library.model.Type;
import ru.intervale.library.service.exception.NotAvailableProductTypeException;
import ru.intervale.library.service.exception.ObligatoryMagazineFieldException;

import java.util.List;

@Service
public class MagazineService {
    @Autowired
    private MagazineRepository magazineRepo;

    public List<PrintProduct> findAllMagazines() {
        List<PrintProduct> magazines = (List<PrintProduct>) magazineRepo.findAll();
        return magazines;
    }

    public PrintProduct findMagazineById(Long id) {
        PrintProduct magazine = magazineRepo.findById(id).get();
        return magazine;
    }

    public List<PrintProduct> findMagazinesByDate(String date) {
        List<PrintProduct> magazines = magazineRepo.findMagazineByDate(date);
        return magazines;
    }

    public List<PrintProduct> findMagazinesByName(String name) {
        List<PrintProduct> magazines = magazineRepo.findMagazineByName(name);
        return magazines;
    }

    public List<PrintProduct> findMagazinesByGenre(String genre) {
        List<PrintProduct> magazines = magazineRepo.findMagazineByGenre(genre.toUpperCase());
        return magazines;
    }

    public PrintProduct createMagazine(PrintProduct printProduct) throws ObligatoryMagazineFieldException {
        if (printProduct.getGenre() == null || printProduct.getName() == null) {
            throw new ObligatoryMagazineFieldException();
        }
        PrintProduct magazine = magazineRepo.save(printProduct);
        return magazine;
    }

    public PrintProduct updateMagazine(PrintProduct printProduct) {
        PrintProduct magazine = magazineRepo.save(printProduct);
        return magazine;
    }

    public PrintProduct partialUpdateMagazine(Long id, PrintProduct printProduct) throws NotAvailableProductTypeException {
        PrintProduct magazine = magazineRepo.findById(id).get();

        if (printProduct.getAuthor() != null) {
            magazine.setAuthor(printProduct.getAuthor());
        }
        if (printProduct.getName() != null) {
            magazine.setName(printProduct.getName());
        }
        if (printProduct.getDatePublished() != null) {
            magazine.setDatePublished(printProduct.getDatePublished());
        }
        if (printProduct.getType() != Type.MAGAZINE && printProduct.getType() != null) {
            throw new NotAvailableProductTypeException();
        }
        magazineRepo.save(magazine);
        return magazine;
    }

    public void deleteMagazineById(Long id) {
        magazineRepo.deleteById(id);
    }
}
