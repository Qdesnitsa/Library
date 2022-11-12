package ru.intervale.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.intervale.library.dao.PrintProductRepository;
import ru.intervale.library.model.PrintProduct;
import ru.intervale.library.model.Type;
import ru.intervale.library.service.exception.NotAvailableProductTypeException;

import java.util.Arrays;
import java.util.List;

@Service
public class PrintProductService {
    @Autowired
    PrintProductRepository productRepo;

    public List<PrintProduct> findAllPrintProducts(String type, String name, String author, String date, String genre) {
        List<PrintProduct> printProducts = productRepo.findAll(type, name, author, date, genre);
        return printProducts;
    }

    public PrintProduct findPrintProductById(Long id) {
        PrintProduct printProduct = productRepo.findById(id).get();
        return printProduct;
    }

    public PrintProduct createPrintProduct(PrintProduct printProduct) {
        PrintProduct targetProduct = productRepo.save(printProduct);
        return targetProduct;
    }

    public PrintProduct partialUpdatePrintProduct(Long id, PrintProduct printProduct) throws NotAvailableProductTypeException {
        PrintProduct targetProduct = productRepo.findById(id).get();

        if (printProduct.getType() != null) {
            boolean isAvailableType = Arrays.stream(Type.values())
                    .anyMatch(availType -> availType.equals(printProduct.getType()));
            if (isAvailableType) {
                targetProduct.setType(printProduct.getType());
            }
        } else {
            throw new NotAvailableProductTypeException();
        }

        productRepo.save(targetProduct);
        return targetProduct;
    }

    public void deletePrintProductById(Long id) {
        productRepo.deleteById(id);
    }
}
