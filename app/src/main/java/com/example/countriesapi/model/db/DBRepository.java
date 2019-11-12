package com.example.countriesapi.model.db;

import com.example.countriesapi.model.entity.Country;

import java.util.List;


public interface DBRepository {

    int insert(Country country);
    int delete(Country country);
    int modify(Country country);
    Country getById(int id);
    List<Country> getAll();


    Country getByName(String name);

    void deleteById(int id);
}
