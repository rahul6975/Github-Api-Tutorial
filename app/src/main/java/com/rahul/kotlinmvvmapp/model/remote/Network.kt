package com.rahul.kotlinmvvmapp.model.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {
    private val httpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(ApiConstants.BASE_URL)
            .client(OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build())
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}