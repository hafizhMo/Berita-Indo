package com.hafizhmo.beritaindojava.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    //create request method using class ApiService
    public ApiService getApi() {
        return new Retrofit.Builder()
                .baseUrl("https://api-berita-indonesia.vercel.app/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiService.class);
    }
}
