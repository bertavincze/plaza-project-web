package com.codecool.api.dao;

import com.codecool.api.model.Plaza;
import com.codecool.api.model.Shop;

import java.sql.SQLException;
import java.util.List;

public interface ShopDao {

    List<Shop> getAllShops(Plaza plaza) throws SQLException;

    void addShop(Shop shop) throws SQLException;

    void removeShop(Shop shop) throws SQLException;

    Shop findByName(String name) throws SQLException;
}
