package com.shinkevich.dishcraft.data.entity

import android.graphics.Bitmap

data class Step(
    var stepId: Int,
    var stepDescription: String,
    var numberInRecipe: Int,
    var image: Bitmap?
) {
}