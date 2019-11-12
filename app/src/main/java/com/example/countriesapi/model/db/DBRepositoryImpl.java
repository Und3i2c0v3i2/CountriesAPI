package com.example.countriesapi.model.db;


import com.example.countriesapi.model.entity.Country;

import java.util.List;

public class DBRepositoryImpl implements DBRepository {

    private DBHelper dbHelper;

    public DBRepositoryImpl(DBHelper dbHelper) {
        this.dbHelper = dbHelper;

    }

    // CRUD
    @Override
    public int insert(Country country) {
        return dbHelper.insert(country);
    }

    @Override
    public int delete(Country country) {
//        dbHelper.deleteById(country.getId());
//        return country.getId();
        return 0;
    }

    @Override
    public int modify(Country country) {
        return dbHelper.modify(country);
    }

    @Override
    public List<Country> getAll() {
        return dbHelper.getAll();
    }

    @Override
    public Country getByName(String name) {
        return dbHelper.getByName(name);
    }

    @Override
    public void deleteById(int id) {
        dbHelper.deleteById(id);
    }

    @Override
    public Country getById(int id) {
        return dbHelper.getById(id);
    }

//    @Override
//    public int insert(Phone phone) {
//        return dbHelper.insert(phone);
//    }
//
//    @Override
//    public List<Phone> getByCountry(int id) {
//        return dbHelper.getByCountry(id);
//    }


}
