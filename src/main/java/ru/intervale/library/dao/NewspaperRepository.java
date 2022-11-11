package ru.intervale.library.dao;

import org.springframework.data.repository.CrudRepository;
import ru.intervale.library.model.PrintProduct;

public interface NewspaperRepository extends CrudRepository<PrintProduct, Long> {
}
