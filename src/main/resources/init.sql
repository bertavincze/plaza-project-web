DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS shops;
DROP TABLE IF EXISTS plaza;

CREATE TABLE plaza(
    name text PRIMARY KEY
);

CREATE TABLE shops(
    name text PRIMARY KEY,
    owner text NOT NULL,
    plaza_name text,
    FOREIGN KEY (plaza_name) REFERENCES plaza (name)
);

CREATE TABLE products(
     barcode integer PRIMARY KEY,
     name text NOT NULL,
     manufacturer text NOT NULL,
     class text NOT NULL,
     calories int DEFAULT NULL,
     best_before date DEFAULT NULL,
     material text DEFAULT NULL,
     type text DEFAULT NULL,
     shop_name text,
     foreign key (shop_name) REFERENCES shop(name)
);
