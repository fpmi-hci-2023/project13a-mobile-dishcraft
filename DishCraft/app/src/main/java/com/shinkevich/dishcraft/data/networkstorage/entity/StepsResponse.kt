package com.shinkevich.dishcraft.data.networkstorage.entity

import com.google.gson.annotations.SerializedName

data class StepsResponse (

    @SerializedName("stepId"          ) var stepId          : Int,
    @SerializedName("stepDescription" ) var stepDescription : String,
    @SerializedName("image"           ) var image           : Image,
    @SerializedName("numberInRecipe"  ) var numberInRecipe  : Int,
    @SerializedName("recipe"          ) var recipe          : RecipeContent

)
