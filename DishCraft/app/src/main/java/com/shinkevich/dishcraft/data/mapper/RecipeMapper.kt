package com.shinkevich.dishcraft.data.mapper

import com.shinkevich.dishcraft.data.entity.Page
import com.shinkevich.dishcraft.data.entity.RecipeShort
import com.shinkevich.dishcraft.data.networkstorage.entity.RecipeContent
import com.shinkevich.dishcraft.data.networkstorage.entity.RecipeResponse


class RecipeMapper {
    companion object {
        fun recipeResponseToRecipePage(response: RecipeResponse): Page<RecipeShort> {
            val recipeList = mutableListOf<RecipeShort>()
            for (recipe in response.content) {
                recipeList.add(
                    recipeContentToRecipeShort(recipe)
                )
            }
            val nextPage = if (response.pageable.pageNumber == response.totalPages - 1) {
                null
            } else {
                response.pageable.pageNumber
            }
            return Page(recipeList, nextPage)
        }

        fun recipeContentToRecipeShort(recipeContent: RecipeContent): RecipeShort {
            return RecipeShort(
                recipeContent.recipeId,
                recipeContent.recipeName,
                recipeContent.description,
                recipeContent.cookingTimeMinutes,
                recipeContent.readyTimeMinutes,
                recipeContent.complexity.complexityName,
                recipeContent.defaultPortionsNumber,
                ImageMapper.imageToBitmap(recipeContent.image),
                recipeContent.user.username
            )
        }
    }
}