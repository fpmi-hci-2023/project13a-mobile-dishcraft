package com.shinkevich.dishcraft.view.entity

import android.graphics.Bitmap

data class RecipePreview(
    var recipeId: Int,
    var recipeName: String,
    var cookingTimeMinutes: Int,
    var readyTimeMinutes : Int,
    var complexity: String,
    var image : Bitmap?
) {
    constructor() : this(
        0,
        "",
        0,
        0,
        "",
        null
    )
}
