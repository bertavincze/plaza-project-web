package com.codecool.api.dao;

import com.codecool.api.model.Product;
import com.codecool.api.model.Shop;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {

    List<Product> getAllProducts(Shop shop) throws SQLException;

    void addProduct(Product product) throws SQLException;

    void removeProduct(Product product) throws SQLException;

    void updateProduct(Product product) throws SQLException;

    Product findByName(String name) throws SQLException;
}
