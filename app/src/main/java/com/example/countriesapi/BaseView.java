package com.example.countriesapi;

import com.example.countriesapi.presenter.BasePresenter;

public interface BaseView {

    void setPresenter(BasePresenter presenter);

    void showToast(String message);
}
