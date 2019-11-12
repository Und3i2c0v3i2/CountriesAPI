package com.example.countriesapi.retrofit;

import com.example.countriesapi.model.entity.Country;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

import static com.example.countriesapi.retrofit.ServiceContract.X_RAPIDAPI_HOST;
import static com.example.countriesapi.retrofit.ServiceContract.X_RAPIDAPI_KEY;

public interface RetrofitApiEndpoints {


    @GET("all")
    Call<List<Country>> getAll(@Header(X_RAPIDAPI_HOST) String host, @Header(X_RAPIDAPI_KEY) String key);

    @GET("name/{name}")
    Call<List<Country>> getByName(@Header(X_RAPIDAPI_HOST) String host, @Header(X_RAPIDAPI_KEY) String key, @Path("name") String name);

    @GET("capital/{city}")
    Call<List<Country>> getByCapital(@Header(X_RAPIDAPI_HOST) String host, @Header(X_RAPIDAPI_KEY) String key, @Path("city") String name);

    @GET("lang/{lang}")
    Call<List<Country>> getByLang(@Header(X_RAPIDAPI_HOST) String host, @Header(X_RAPIDAPI_KEY) String key, @Path("lang") String name);

    @GET("region/{region}")
    Call<List<Country>> getByRegion(@Header(X_RAPIDAPI_HOST) String host, @Header(X_RAPIDAPI_KEY) String key, @Path("region") String name);
}
