package com.jun.mock.Model

import com.google.gson.annotations.SerializedName


data class CategoryJSONResponse (

    @SerializedName("arrayOfProducts")
    val arr: ArrayList<CategoryResponseModel>
)