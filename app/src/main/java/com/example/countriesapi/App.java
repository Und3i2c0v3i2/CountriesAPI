package com.example.countriesapi;

import android.app.Application;

import com.example.countriesapi.model.db.DBHelper;
import com.example.countriesapi.model.db.DBRepository;
import com.example.countriesapi.model.db.DBRepositoryImpl;


public class App extends Application {


    private static DBHelper dbHelper;
    private static DBRepository dbRepository;


    @Override
    public void onCreate() {
        super.onCreate();

        dbHelper = DBHelper.getInstance(this);
        dbRepository = new DBRepositoryImpl(dbHelper);
    }


    public static DBRepository getDbRepository() {
        return dbRepository;
    }



}
