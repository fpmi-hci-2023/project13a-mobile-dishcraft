package com.shinkevich.dishcraft.data.networkstorage.entity

import com.google.gson.annotations.SerializedName

data class RecipeContent(

    @SerializedName("recipeId") var recipeId: Int,
    @SerializedName("recipeName") var recipeName: String,
    @SerializedName("description") var description: String,
    @SerializedName("image") var image: Image,
    @SerializedName("cookingTimeMinutes") var cookingTimeMinutes: Int,
    @SerializedName("readyTimeMinutes") var readyTimeMinutes: Int,
    @SerializedName("complexity") var complexity: Complexity,
    @SerializedName("defaultPortionsNumber") var defaultPortionsNumber: Int,
    @SerializedName("user") var user: User
    //@SerializedName("imagePath") var imagePath: ImagePath

)