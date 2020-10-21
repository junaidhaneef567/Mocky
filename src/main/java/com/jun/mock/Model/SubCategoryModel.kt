package com.jun.mock.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SubCategoryModel (

    @SerializedName("imgUrl")
    @Expose
    val imgUrl:String,
    @SerializedName("name")
    @Expose
    val name:String,
    @SerializedName("category")
    @Expose
    val category:String,
    @SerializedName("quantity")
    @Expose
    val quantity:Int = 0,
    @SerializedName("description")
    @Expose
    val description:String,
    @SerializedName("price")
    @Expose
    val price:String
)