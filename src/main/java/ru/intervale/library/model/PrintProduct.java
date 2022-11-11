package ru.intervale.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Table("PRINT_PRODUCTS")
public class PrintProduct extends AbstractEntity {
    private Type type;
    private String name;
    private LocalDate datePublished;
    private String author;
}
