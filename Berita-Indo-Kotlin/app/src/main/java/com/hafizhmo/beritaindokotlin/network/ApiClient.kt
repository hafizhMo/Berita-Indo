package com.hafizhmo.beritaindokotlin.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object {

        fun builder(): ApiService? {
            return Retrofit.Builder()
                .baseUrl("https://api-berita-indonesia.vercel.app/")
                .client(createClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiService::class.java)
        }

        private fun createClient(): OkHttpClient {
            val okHttpClient: OkHttpClient.Builder = OkHttpClient.Builder()
                .addInterceptor {
                    val request = it.request()
                    val newUrl = request.url().newBuilder()
                        .build()
                    it.proceed(
                        request.newBuilder()
                            .url(newUrl)
                            .build())
                }

            return okHttpClient.build()
        }
    }

}