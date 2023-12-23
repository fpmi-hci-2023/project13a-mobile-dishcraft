package com.shinkevich.dishcraft.data.networkstorage.entity

import com.google.gson.annotations.SerializedName

data class Rating(

    @SerializedName("ratingId") var ratingId: Int,
    @SerializedName("ratingValue") var ratingValue: Int,
    @SerializedName("user") var user: User,
    @SerializedName("recipe") var recipe: RecipeContent

)