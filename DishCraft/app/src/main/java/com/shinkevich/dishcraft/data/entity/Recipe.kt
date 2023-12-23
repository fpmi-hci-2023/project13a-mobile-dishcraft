package com.shinkevich.dishcraft.data.entity

import com.shinkevich.dishcraft.data.networkstorage.entity.Comment
import com.shinkevich.dishcraft.data.networkstorage.entity.Rating

data class Recipe(
    var recipeShort: RecipeShort? = null,
    var nutritionalValue: NutritionalValue? = null,
    var steps: List<Step> = listOf(),
    var products : List<Product>,
    var avgRating: Double,
    var ratings : List<Rating>,
    var comments : List<Comment>
) {

}