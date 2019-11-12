package com.example.countriesapi.presenter;

import com.example.countriesapi.App;
import com.example.countriesapi.model.db.DBRepository;
import com.example.countriesapi.model.entity.Country;
import com.example.countriesapi.retrofit.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.countriesapi.retrofit.ServiceContract.X_RAPID_API_HOST_VALUE;
import static com.example.countriesapi.retrofit.ServiceContract.X_RAPID_API_KEY_VALUE;

public class DetailsPresenterImpl implements DetailsContract.Presenter {

    private DetailsContract.View view;

    public DetailsPresenterImpl(DetailsContract.View view) {
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void actionName(String name) {

        Call<List<Country>> call = RetrofitService.getApiService().getByName(X_RAPID_API_HOST_VALUE, X_RAPID_API_KEY_VALUE, name);
        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {

                if (response.code() == 200) {
                    List<Country> list = response.body();

                    if(list != null && !list.isEmpty()) {
                        view.showSelected(list.get(0));
                    }
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
