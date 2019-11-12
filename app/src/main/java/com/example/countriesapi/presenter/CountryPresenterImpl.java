package com.example.countriesapi.presenter;

import com.example.countriesapi.model.entity.Country;
import com.example.countriesapi.retrofit.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.countriesapi.retrofit.ServiceContract.X_RAPID_API_HOST_VALUE;
import static com.example.countriesapi.retrofit.ServiceContract.X_RAPID_API_KEY_VALUE;

public class CountryPresenterImpl implements CountryContract.Presenter {


    private CountryContract.View view;

    public CountryPresenterImpl(CountryContract.View view) {
        this.view = view;
        this.view.setPresenter(this);
    }


    @Override
    public void actionAll() {


        Call<List<Country>> call = RetrofitService.getApiService().getAll(X_RAPID_API_HOST_VALUE, X_RAPID_API_KEY_VALUE);
        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {

                if (response.code() == 200) {
                    List<Country> list = response.body();

                    view.showAll(list);
                }
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                view.showToast("Nesto je trulo u drzavi Danskoj");
            }
        });


    }

    @Override
    public void actionCapital(String name) {
        Call<List<Country>> call = RetrofitService.getApiService().getByCapital(X_RAPID_API_HOST_VALUE, X_RAPID_API_KEY_VALUE, name);
        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {

                if (response.code() == 200) {
                    List<Country> list = response.body();

                    view.showAll(list);
                }
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                view.showToast("Nesto je trulo u drzavi Danskoj");
            }
        });
    }

    @Override
    public void actionLang(String name) {
        Call<List<Country>> call = RetrofitService.getApiService().getByLang(X_RAPID_API_HOST_VALUE, X_RAPID_API_KEY_VALUE, name);
        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {

                if (response.code() == 200) {
                    List<Country> list = response.body();

                    view.showAll(list);
                }
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                view.showToast("Nesto je trulo u drzavi Danskoj");
            }
        });

    }

    @Override
    public void actionRegion(String name) {
        Call<List<Country>> call = RetrofitService.getApiService().getByRegion(X_RAPID_API_HOST_VALUE, X_RAPID_API_KEY_VALUE, name);
        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {

                if (response.code() == 200) {
                    List<Country> list = response.body();

                    view.showAll(list);
                }
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                view.showToast("Nesto je trulo u drzavi Danskoj");
            }
        });

    }

    @Override
    public void actionName(String name) {
        Call<List<Country>> call = RetrofitService.getApiService().getByName(X_RAPID_API_HOST_VALUE, X_RAPID_API_KEY_VALUE, name);
        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {

                if (response.code() == 200) {
                    List<Country> list = response.body();

                    view.showAll(list);
                }
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                view.showToast("Nesto je trulo u drzavi Danskoj");
            }
        });
    }

    @Override
    public void onDestroy() {
        this.view = null;
    }


}
