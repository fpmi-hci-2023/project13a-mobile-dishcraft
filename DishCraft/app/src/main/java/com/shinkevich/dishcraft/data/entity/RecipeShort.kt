package com.shinkevich.dishcraft.data.entity

import android.graphics.Bitmap

data class RecipeShort(
    var recipeId: Int,
    var recipeName: String,
    var description: String,
    var cookingTimeMinutes: Int,
    var readyTimeMinutes: Int,
    var complexity: String,
    var defaultPortionsNumber: Int,
    var image : Bitmap?,
    var authorUsername : String
) {
    constructor() : this(
        0,
        "",
        "",
        0, 0,
        "",
        0,
        null,
        ""
    )
}

/*
data class RecipeUser(
    var id: Int,
    var username: String
) {
    constructor() : this(111, "user 111")
}*/