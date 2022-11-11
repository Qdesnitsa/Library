CREATE TABLE print_products (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    type VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    date_published DATE NOT NULL,
    author VARCHAR(255),
    number_of_pages INTEGER NOT NULL
)