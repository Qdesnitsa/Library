package ru.intervale.library.dao;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.intervale.library.model.PrintProduct;

import java.util.List;

public interface NewspaperRepository extends CrudRepository<PrintProduct, Long> {
    @Override
    @Query("SELECT * FROM print_products WHERE type = 'NEWSPAPER' ORDER BY name")
    Iterable<PrintProduct> findAll();

    @Query("SELECT * FROM print_products WHERE type = 'NEWSPAPER' AND date_published LIKE CONCAT('%', :datePublished, '%')")
    List<PrintProduct> findNewspaperByDate(@Param("datePublished")String date);

    @Query("SELECT * FROM print_products WHERE type = 'NEWSPAPER' AND name LIKE CONCAT('%', :name, '%')")
    List<PrintProduct> findNewspaperByName(@Param("name")String name);

    @Query("SELECT * FROM print_products WHERE type = 'NEWSPAPER' AND genre LIKE CONCAT('%', :genre, '%')")
    List<PrintProduct> findNewspaperByGenre(@Param("genre")String genre);
}
