package com.codecool.api.dao;

import com.codecool.api.model.Plaza;

import java.sql.SQLException;
import java.util.List;

public interface PlazaDao {

    List<Plaza> getAllPlazas() throws SQLException;

    void addPlaza(Plaza plaza) throws SQLException;

    void removePlaza(Plaza plaza) throws SQLException;

    Plaza findByName(String name) throws SQLException;
}
