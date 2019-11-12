package com.example.countriesapi.presenter;

import com.example.countriesapi.BaseView;
import com.example.countriesapi.model.entity.Country;

import java.util.List;


public interface CountryContract {

    interface Presenter extends BasePresenter {

        void actionAll();

        void actionCapital(String name);
        void actionLang(String name);
        void actionRegion(String name);
        void actionName(String name);
    }

    interface View extends BaseView {

        void showAll(List<Country> list);
    }
}
