package ru.intervale.library;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.intervale.library.dao.PrintProductRepository;
import ru.intervale.library.model.PrintProduct;
import ru.intervale.library.model.Type;

import java.time.LocalDate;

@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }

//    @Bean
//    ApplicationRunner applicationRunner(PrintProductRepository printProductRepository) {
//        return args -> {
//          PrintProduct product1 = new PrintProduct(Type.BOOK,"ABC", LocalDate.parse("1998-02-02"),"Pushkin");
//          PrintProduct product2 = new PrintProduct(Type.BOOK,"ABCDEFG", LocalDate.parse("2010-11-07"),"Lermontov");
//          PrintProduct product3 = new PrintProduct(Type.MAGAZINE,"ABCDEFGHILK", LocalDate.parse("2010-11-07"),"Fashion LLC");
//
//            System.out.println(printProductRepository.save(product1));
//            System.out.println(printProductRepository.save(product2));
//            System.out.println(printProductRepository.save(product3));
//
//        };
//    }
}
