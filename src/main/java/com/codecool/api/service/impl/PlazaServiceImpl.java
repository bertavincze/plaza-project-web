package com.codecool.api.service.impl;

import com.codecool.api.dao.PlazaDao;
import com.codecool.api.model.Plaza;
import com.codecool.api.service.PlazaService;
import com.codecool.api.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public final class PlazaServiceImpl implements PlazaService {

    private final PlazaDao plazaDao;

    public PlazaServiceImpl(PlazaDao plazaDao) {
        this.plazaDao = plazaDao;
    }

    @Override
    public List<Plaza> getAllPlazas() throws SQLException {
        return null;
    }

    @Override
    public void addPlaza(Plaza plaza) throws SQLException, ServiceException {
    }

    @Override
    public void removePlaza(Plaza plaza) throws SQLException, ServiceException {
    }

    @Override
    public Plaza findByName(String name) throws SQLException {
        return null;
    }
}
