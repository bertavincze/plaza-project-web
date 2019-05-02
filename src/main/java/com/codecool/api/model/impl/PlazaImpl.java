package com.codecool.api.model.impl;


import com.codecool.api.exception.NoSuchShopException;
import com.codecool.api.exception.PlazaIsClosedException;
import com.codecool.api.exception.ShopAlreadyExistsException;
import com.codecool.api.model.Plaza;
import com.codecool.api.model.Shop;

import java.util.ArrayList;
import java.util.List;

public class PlazaImpl implements Plaza {

    private String name;
    private List<Shop> shops;
    private boolean isOpen;

    public PlazaImpl(String name) {
        this.name = name;
        this.shops = new ArrayList<>();
    }

    @Override
    public List<Shop> getShops() throws PlazaIsClosedException {
        if (isOpen) {
            return shops;
        } else {
            throw new PlazaIsClosedException();
        }

    }

    @Override
    public void addShop(Shop shop) throws ShopAlreadyExistsException, PlazaIsClosedException {
        if (isOpen) {
            if (!shops.contains(shop)) {
                shops.add(shop);
            } else {
                throw new ShopAlreadyExistsException();
            }
        } else {
            throw new PlazaIsClosedException();
        }
    }

    @Override
    public void removeShop(Shop shop) throws NoSuchShopException, PlazaIsClosedException {
        if (isOpen) {
            if (shops.contains(shop)) {
                shops.remove(shop);
            } else {
                throw new NoSuchShopException();
            }
        } else {
            throw new PlazaIsClosedException();
        }
    }

    @Override
    public Shop findShopByName(String name) throws NoSuchShopException, PlazaIsClosedException {
        if (isOpen) {
            for (Shop shop : shops) {
                if (shop.getName().equals(name)) {
                    return shop;
                }
            }
            throw new NoSuchShopException();
        } else {
            throw new PlazaIsClosedException();
        }
    }

    @Override
    public boolean isOpen() {
        return isOpen;
    }

    @Override
    public void open() {
        this.isOpen = true;
    }

    @Override
    public void close() {
        this.isOpen = false;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
