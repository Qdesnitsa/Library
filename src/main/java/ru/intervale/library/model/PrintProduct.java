package ru.intervale.library.model;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;

@Data
@Table("print_products")
public class PrintProduct extends AbstractEntity {
    private Type type;
    private String name;
    private Date datePublished;
    private String author;
    private int numberOfPages;
}
