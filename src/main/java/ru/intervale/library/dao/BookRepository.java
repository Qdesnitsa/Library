package ru.intervale.library.dao;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.intervale.library.model.PrintProduct;

import java.util.List;

public interface BookRepository extends CrudRepository<PrintProduct, Long> {
    @Query("SELECT * FROM print_products WHERE type = 'BOOK' AND author = :author")
    List<PrintProduct> findBookByAuthor(@Param("author")String author);

    @Override
    @Query("SELECT * FROM print_products WHERE type = 'BOOK'")
    Iterable<PrintProduct> findAll();
}
