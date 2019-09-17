package com.johnfneto.newsfeed.services

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

class Service {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <S> createService(serviceClass: Class<S>): S {
        return retrofit.create(serviceClass)
    }
}