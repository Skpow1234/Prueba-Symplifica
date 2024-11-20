CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    price VARCHAR(255),
    current_stock INT
);

CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    product_id INT,
    FOREIGN KEY (product_id) REFERENCES products (id)
);
