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

    public List<PrintProduct> getAllPrintProducts(String type, String name, String author, String date) {
        List<PrintProduct> printProducts = productRepo.findAll(type, name, author, date);
        return printProducts;
    }

    public PrintProduct getPrintProductById(Long id) {
        PrintProduct printProduct = productRepo.findById(id).get();
        return printProduct;
    }

    public PrintProduct createPrintProduct(PrintProduct printProduct) {
        PrintProduct targetProduct = productRepo.save(printProduct);
        return printProduct;
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
            throw new NotAvailableProductTypeException("Product type is incorrect");
        }

        productRepo.save(targetProduct);
        return targetProduct;
    }

    public void deletePrintProductById(Long id) {
        productRepo.deleteById(id);
    }
}
