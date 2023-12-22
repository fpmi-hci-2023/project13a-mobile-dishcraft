package com.shinkevich.dishcraft.data.mapper

import com.shinkevich.dishcraft.data.entity.NutritionalValue
import com.shinkevich.dishcraft.data.networkstorage.entity.NutritionalValueResponse

class NutrValueMapper {
    companion object {
        fun responseToNutrValue(nutrValueResponse: NutritionalValueResponse): NutritionalValue {
            return NutritionalValue(
                nutrValueResponse.calories,
                nutrValueResponse.proteins,
                nutrValueResponse.fats,
                nutrValueResponse.carbohydrates
            )
        }
    }
}