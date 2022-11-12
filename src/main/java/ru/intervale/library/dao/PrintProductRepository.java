package ru.intervale.library.dao;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.intervale.library.model.PrintProduct;

import java.util.List;

public interface PrintProductRepository extends CrudRepository<PrintProduct, Long> {

    @Query("SELECT * FROM print_products WHERE " +
            "type LIKE CONCAT('%', :type, '%') AND " +
            "name LIKE CONCAT('%', :name, '%') AND " +
            "author LIKE CONCAT('%', :author, '%') AND " +
            "date_published LIKE CONCAT('%', :datePublished, '%') AND " +
            "genre LIKE CONCAT('%', :genre, '%')")
    List<PrintProduct> findAll(@Param("type") String type,
                               @Param("name") String name,
                               @Param("author") String author,
                               @Param("datePublished") String datePublished,
                               @Param("genre") String genre);

    @Query("SELECT * FROM print_products WHERE author = :author ORDER BY name")
    List<PrintProduct> findByAuthor(@Param("author") String author);
}
