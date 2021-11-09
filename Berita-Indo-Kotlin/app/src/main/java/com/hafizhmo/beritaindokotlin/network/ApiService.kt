package com.hafizhmo.beritaindokotlin.network

import com.hafizhmo.beritaindokotlin.data.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("{source}/terbaru")
    fun getNews(@Path("source") source: String?): Call<News>

}