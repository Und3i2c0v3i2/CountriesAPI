package com.example.countriesapi.presenter;

import com.example.countriesapi.BaseView;
import com.example.countriesapi.model.entity.Country;


public interface DetailsContract {

    interface Presenter extends BasePresenter {

        void actionName(String name);
    }

    interface View extends BaseView {

        void showSelected(Country c);
    }
}
