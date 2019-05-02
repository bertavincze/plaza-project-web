package com.codecool.api.service.impl;

import com.codecool.api.dao.ProductDao;
import com.codecool.api.model.Product;
import com.codecool.api.model.Shop;
import com.codecool.api.service.ProductService;
import com.codecool.api.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public final class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAllProducts(Shop shop) throws SQLException {
        return null;
    }

    @Override
    public void addProduct(Product product) throws SQLException, ServiceException {
    }

    @Override
    public void removeProduct(Product product) throws SQLException, ServiceException {
    }

    @Override
    public void updateProduct(Product product) throws SQLException, ServiceException {
    }

    @Override
    public Product findByName(String name) throws SQLException {
        return null;
    }
}
