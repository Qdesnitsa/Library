package ru.intervale.library.dao;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.intervale.library.model.PrintProduct;

import java.util.List;

public interface BookRepository extends CrudRepository<PrintProduct, Long> {
    @Override
    @Query("SELECT * FROM print_products WHERE type = 'BOOK' ORDER BY name")
    Iterable<PrintProduct> findAll();

    @Query("SELECT * FROM print_products WHERE type = 'BOOK' AND author = :author")
    List<PrintProduct> findBookByAuthor(@Param("author")String author);

    @Query("SELECT * FROM print_products WHERE type = 'BOOK' AND date_published LIKE CONCAT('%', :datePublished, '%')")
    List<PrintProduct> findBookByDate(@Param("datePublished")String date);

    @Query("SELECT * FROM print_products WHERE type = 'BOOK' AND name LIKE CONCAT('%', :name, '%')")
    List<PrintProduct> findBookByName(@Param("name")String name);

    @Query("SELECT * FROM print_products WHERE type = 'BOOK' AND genre LIKE CONCAT('%', :genre, '%')")
    List<PrintProduct> findBookByGenre(@Param("genre")String genre);
}
