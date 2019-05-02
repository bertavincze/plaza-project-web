package com.codecool.api.service;

import com.codecool.api.model.Plaza;
import com.codecool.api.model.Shop;
import com.codecool.api.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public interface ShopService {

    List<Shop> getAllShops(Plaza plaza) throws SQLException;

    void addShop(Shop shop) throws SQLException, ServiceException;

    void removeShop(Shop shop) throws SQLException, ServiceException;

    Shop findByName(String name) throws SQLException;
}
