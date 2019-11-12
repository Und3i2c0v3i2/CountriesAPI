package com.example.countriesapi.retrofit;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private static Retrofit getRetrofitInstance(){

        return new Retrofit.Builder()
                .baseUrl(ServiceContract.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * Definisemo konkretnu instancu servisa na intnerntu sa kojim
     * vrsimo komunikaciju
     * */
    public static RetrofitApiEndpoints getApiService(){
        return getRetrofitInstance().create(RetrofitApiEndpoints.class);
    }
}
