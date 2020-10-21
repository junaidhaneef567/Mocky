package com.jun.mock.Network

import com.jun.mock.Model.CategoryJSONResponse
import com.jun.mock.Model.SubCategoryJSONResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("5e16d5263000002a00d5616c")
    fun getCategories(): Call<CategoryJSONResponse>

    @GET("5e16d5443000004e00d5616d")
    fun getSubCategories(): Call<SubCategoryJSONResponse>
}