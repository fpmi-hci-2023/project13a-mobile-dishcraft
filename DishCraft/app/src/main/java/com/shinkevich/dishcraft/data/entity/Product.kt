package com.shinkevich.dishcraft.data.entity

import android.graphics.Bitmap

data class Product(
    var productId: Int,
    var productName: String,
    var image: Bitmap?,
    var calories: Double,
    var proteins: Double,
    var fats: Double,
    var carbohydrates: Double
)