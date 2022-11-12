package ru.intervale.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Table("PRINT_PRODUCTS")
public class PrintProduct extends AbstractEntity {
    @NotNull
    private Type type;
    private String name;
    private LocalDate datePublished;
    private String author;
    private Genre genre;
}
