package ru.intervale.library.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public abstract class AbstractEntity {
    @Id
    private Long id;
}
