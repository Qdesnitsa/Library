package ru.intervale.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.intervale.library.dao.NewspaperRepository;
import ru.intervale.library.model.PrintProduct;
import ru.intervale.library.model.Type;
import ru.intervale.library.service.exception.NotAvailableProductTypeException;
import ru.intervale.library.service.exception.ObligatoryNewspaperFieldException;

import java.util.List;

@Service
public class NewspaperService {
    @Autowired
    private NewspaperRepository newspaperRepo;

    public List<PrintProduct> findAllNewspapers() {
        List<PrintProduct> newspapers = (List<PrintProduct>) newspaperRepo.findAll();
        return newspapers;
    }

    public PrintProduct findNewspaperById(Long id) {
        PrintProduct newspaper = newspaperRepo.findById(id).get();
        return newspaper;
    }

    public List<PrintProduct> findNewspaperByDate(String date) {
        List<PrintProduct> newspapers = newspaperRepo.findNewspaperByDate(date);
        return newspapers;
    }

    public List<PrintProduct> findNewspaperByName(String name) {
        List<PrintProduct> newspapers = newspaperRepo.findNewspaperByName(name);
        return newspapers;
    }

    public List<PrintProduct> findNewspaperByGenre(String genre) {
        List<PrintProduct> newspapers = newspaperRepo.findNewspaperByGenre(genre.toUpperCase());
        return newspapers;
    }

    public PrintProduct createNewspaper(PrintProduct printProduct) throws ObligatoryNewspaperFieldException {
        if (printProduct.getGenre() == null || printProduct.getName() == null) {
            throw new ObligatoryNewspaperFieldException();
        }
        PrintProduct newspaper = newspaperRepo.save(printProduct);
        return newspaper;
    }

    public PrintProduct updateNewspaper(PrintProduct printProduct) {
        PrintProduct newspaper = newspaperRepo.save(printProduct);
        return newspaper;
    }

    public PrintProduct partialUpdateNewspaper(Long id, PrintProduct printProduct) throws NotAvailableProductTypeException {
        PrintProduct newspaper = newspaperRepo.findById(id).get();

        if (printProduct.getAuthor() != null) {
            newspaper.setAuthor(printProduct.getAuthor());
        }
        if (printProduct.getName() != null) {
            newspaper.setName(printProduct.getName());
        }
        if (printProduct.getDatePublished() != null) {
            newspaper.setDatePublished(printProduct.getDatePublished());
        }
        if (printProduct.getType() != Type.MAGAZINE && printProduct.getType() != null) {
            throw new NotAvailableProductTypeException();
        }
        newspaperRepo.save(newspaper);
        return newspaper;
    }

    public void deleteNewspaperById(Long id) {
        newspaperRepo.deleteById(id);
    }
}
