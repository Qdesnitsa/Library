package ru.intervale.library.dao;

import org.springframework.data.repository.CrudRepository;
import ru.intervale.library.model.PrintProduct;

public interface MagazineRepository extends CrudRepository<PrintProduct, Long> {
}
