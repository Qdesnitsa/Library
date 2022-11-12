package ru.intervale.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.intervale.library.dao.BookRepository;
import ru.intervale.library.model.PrintProduct;
import ru.intervale.library.model.Type;
import ru.intervale.library.service.exception.NotAvailableProductTypeException;
import ru.intervale.library.service.exception.ObligatoryBookFieldException;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepo;

    public List<PrintProduct> findAllBooks() {
        List<PrintProduct> books = (List<PrintProduct>) bookRepo.findAll();
        return books;
    }

    public PrintProduct findBookById(Long id) {
        PrintProduct book = bookRepo.findById(id).get();
        return book;
    }

    public List<PrintProduct> findBookByAuthor(String author) {
        List<PrintProduct> books = bookRepo.findBookByAuthor(author);
        return books;
    }

    public List<PrintProduct> findBookByDate(String date) {
        List<PrintProduct> books = bookRepo.findBookByDate(date);
        return books;
    }

    public List<PrintProduct> findBookByName(String name) {
        List<PrintProduct> books = bookRepo.findBookByName(name);
        return books;
    }

    public List<PrintProduct> findBookByGenre(String genre) {
        List<PrintProduct> books = bookRepo.findBookByGenre(genre.toUpperCase());
        return books;
    }

    public PrintProduct createBook(PrintProduct printProduct) throws ObligatoryBookFieldException {
        if (printProduct.getAuthor() == null || printProduct.getGenre() == null || printProduct.getName() == null) {
            throw new ObligatoryBookFieldException();
        }
        PrintProduct book = bookRepo.save(printProduct);
        return book;
    }

    public PrintProduct updateBook(PrintProduct printProduct) {
        PrintProduct book = bookRepo.save(printProduct);
        return book;
    }

    public PrintProduct partialUpdateBook(Long id, PrintProduct printProduct) throws NotAvailableProductTypeException {
        PrintProduct book = bookRepo.findById(id).get();

        if (printProduct.getAuthor() != null) {
            book.setAuthor(printProduct.getAuthor());
        }
        if (printProduct.getName() != null) {
            book.setName(printProduct.getName());
        }
        if (printProduct.getDatePublished() != null) {
            book.setDatePublished(printProduct.getDatePublished());
        }
        if (printProduct.getType() != Type.BOOK && printProduct.getType() != null) {
            throw new NotAvailableProductTypeException();
        }
        bookRepo.save(book);
        return book;
    }

    public void deleteBookById(Long id) {
        bookRepo.deleteById(id);
    }
}
