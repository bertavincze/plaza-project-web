package com.codecool.api.service;

import com.codecool.api.model.Plaza;
import com.codecool.api.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public interface PlazaService {

    List<Plaza> getAllPlazas() throws SQLException;

    void addPlaza(Plaza plaza) throws SQLException, ServiceException;

    void removePlaza(Plaza plaza) throws SQLException, ServiceException;

    Plaza findByName(String name) throws SQLException;
}
