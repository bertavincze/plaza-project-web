package com.codecool.api.service.impl;

import com.codecool.api.dao.ShopDao;
import com.codecool.api.model.Plaza;
import com.codecool.api.model.Shop;
import com.codecool.api.service.ShopService;
import com.codecool.api.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public final class ShopServiceImpl implements ShopService {

    private final ShopDao shopDao;

    public ShopServiceImpl(ShopDao shopDao) {
        this.shopDao = shopDao;
    }

    @Override
    public List<Shop> getAllShops(Plaza plaza) throws SQLException {
        return null;
    }

    @Override
    public void addShop(Shop shop) throws SQLException, ServiceException {
    }

    @Override
    public void removeShop(Shop shop) throws SQLException, ServiceException {
    }

    @Override
    public Shop findByName(String name) throws SQLException {
        return null;
    }
}
