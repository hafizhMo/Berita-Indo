package com.hafizhmo.beritaindojava.network;

import com.hafizhmo.beritaindojava.data.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    //TO-DO 1: create methot 'getNews' using retrofit2.http
    @GET("{source}/terbaru")
    Call<News> getNews(@Path("source") String source);
}
