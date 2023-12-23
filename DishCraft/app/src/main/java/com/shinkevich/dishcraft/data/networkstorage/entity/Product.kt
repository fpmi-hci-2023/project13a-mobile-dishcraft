package com.shinkevich.dishcraft.data.networkstorage.entity

import com.google.gson.annotations.SerializedName

data class Product(

    @SerializedName("productId") var productId: Int,
    @SerializedName("productName") var productName: String,
    @SerializedName("image") var image: Image,
    @SerializedName("calories") var calories: Double,
    @SerializedName("proteins") var proteins: Double,
    @SerializedName("fats") var fats: Double,
    @SerializedName("carbohydrates") var carbohydrates: Double

)