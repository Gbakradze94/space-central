DROP TABLE IF EXISTS product;
CREATE TABLE product(
    id BIGSERIAL PRIMARY KEY NOT NULL,
    sku VARCHAR(255) UNIQUE NOT NULL,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    created_date TIMESTAMP NOT NULL,
    last_modified_date TIMESTAMP NOT NULL,
    price float8 NOT NULL,
    version INTEGER NOT NULL
);