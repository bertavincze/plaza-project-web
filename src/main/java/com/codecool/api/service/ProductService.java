package com.codecool.api.service;

import com.codecool.api.model.Product;
import com.codecool.api.model.Shop;
import com.codecool.api.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {

    List<Product> getAllProducts(Shop shop) throws SQLException;

    void addProduct(Product product) throws SQLException, ServiceException;

    void removeProduct(Product product) throws SQLException, ServiceException;

    void updateProduct(Product product) throws SQLException, ServiceException;

    Product findByName(String name) throws SQLException;
}
