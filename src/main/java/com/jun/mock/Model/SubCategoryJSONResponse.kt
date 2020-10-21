package com.jun.mock.Model

import com.google.gson.annotations.SerializedName

data class SubCategoryJSONResponse (
        @SerializedName("arrayOfProducts")
        val arrayOfProducts : ArrayList<SubCategoryModel>
)
