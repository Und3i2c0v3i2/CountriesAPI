package com.example.countriesapi.model.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.countriesapi.model.entity.Country;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DBHelper extends OrmLiteSqliteOpenHelper {


    private static final String DATABASE_NAME = "ormlite.db";
    private static final int DATABASE_VERSION = 1;

    private Dao<Country, Integer> countryDao;

    private static DBHelper instance;


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        try {
            countryDao = getCountryDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Country.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource,
                          int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Country.class, true);
            onCreate(db, connectionSource);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static DBHelper getInstance(Context context) {

        if (instance == null) {
            instance = new DBHelper(context);
        }
        return instance;
    }


    public Dao<Country, Integer> getCountryDao() throws SQLException {
        if (countryDao == null) {
            countryDao = getDao(Country.class);
        }

        return countryDao;
    }


    @Override
    public void close() {
        countryDao = null;
        super.close();
    }

    public int insert(Country country) {

        if (country != null) {

//            if (getById(country.getId()) != null) {
//                return country.getId();

//            }
//        else {

                try {
                    return countryDao.create(country);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

//        }
        return -1;
    }

    // doesn't work without generated id
//    public int delete(Country country) {
//
//        try {
//            return countryDao.delete(country);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return -1;
//    }


    public int modify(Country country) {

        try {
            return countryDao.update(country);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    // custom find by id, because we don't have generated id
    public Country getById(int id) {

        List<Country> list = new ArrayList<>();
//        try {
//            list = countryDao.queryForEq(ID, id);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public Country getByName(String name) {

        List<Country> list = new ArrayList<>();
//        try {
//            list = countryDao.queryForEq(NAME, name);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }


    public List<Country> getAll() {

        List<Country> list = new ArrayList<>();
        try {
            list = countryDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // custom delete, because id is JSON field, not generated value
    public void deleteById(int id) {
//        try {
//            DeleteBuilder builder = countryDao.deleteBuilder();
//            builder.where()
//                    .eq(ID, id);
//            builder.delete();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }


//    public List<Phone> getByCountry(int id) {
//
//        try {
//            return phoneDao.queryForEq(COLUMN_Country_ID, id);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return new ArrayList<>();
//    }


}