package com.jun.mock.Network

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit


class RetrofitClient{

    private val BASE_URL = "http://www.mocky.io/v2/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build() //Doesn't require the adapter
    }

    val api:Api= getRetrofit().create(Api::class.java)

}