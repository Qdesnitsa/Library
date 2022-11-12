package ru.intervale.library.dao;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.intervale.library.model.PrintProduct;

import java.util.List;

public interface MagazineRepository extends CrudRepository<PrintProduct, Long> {
    @Override
    @Query("SELECT * FROM print_products WHERE type = 'MAGAZINE' ORDER BY name")
    Iterable<PrintProduct> findAll();

    @Query("SELECT * FROM print_products WHERE type = 'MAGAZINE' AND date_published LIKE CONCAT('%', :datePublished, '%')")
    List<PrintProduct> findMagazineByDate(@Param("datePublished")String date);

    @Query("SELECT * FROM print_products WHERE type = 'MAGAZINE' AND name LIKE CONCAT('%', :name, '%')")
    List<PrintProduct> findMagazineByName(@Param("name")String name);

    @Query("SELECT * FROM print_products WHERE type = 'MAGAZINE' AND genre LIKE CONCAT('%', :genre, '%')")
    List<PrintProduct> findMagazineByGenre(@Param("genre")String genre);
}
