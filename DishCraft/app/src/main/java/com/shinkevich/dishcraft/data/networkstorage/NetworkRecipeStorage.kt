package com.shinkevich.dishcraft.data.networkstorage

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import com.shinkevich.dishcraft.data.entity.*
import com.shinkevich.dishcraft.data.mapper.NutrValueMapper
import com.shinkevich.dishcraft.data.mapper.ProductMapper
import com.shinkevich.dishcraft.data.mapper.RecipeMapper
import com.shinkevich.dishcraft.data.mapper.StepMapper
import com.shinkevich.dishcraft.data.networkstorage.api.RecipeApi
import com.shinkevich.dishcraft.data.networkstorage.entity.Comment
import com.shinkevich.dishcraft.data.networkstorage.entity.Rating
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NetworkRecipeStorage @Inject constructor(private val api: RecipeApi) {
    suspend fun getRecipes(page: Int, new: Boolean = true): Page<RecipeShort> {
        try {
            val recipesResponse =
                if (new) api.getRecipes(page, "new") else api.getRecipes(page, "popular")
            return RecipeMapper.recipeResponseToRecipePage(recipesResponse.body()!!)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return Page(listOf(), null)
    }

    private suspend fun getRecipeShort(recipeId: Int): RecipeShort {
        val recipeResponse = api.getRecipe(recipeId)
        val recipe = RecipeMapper.recipeContentToRecipeShort(recipeResponse.body()!!)
        //val image = getRecipeImage(recipeId)
        //recipe.image = image
        return recipe
    }

    private suspend fun getRecipeNutritionalValue(recipeId: Int): NutritionalValue {
        val nutrValueResponse = api.getRecipeNutritionalValue(recipeId)
        return NutrValueMapper.responseToNutrValue(nutrValueResponse.body()!!)
    }

    private suspend fun getRecipeProducts(recipeId: Int): List<Product> {
        val productsResponse = api.getRecipeProducts(recipeId)
        return productsResponse.body()!!
            .map { product -> ProductMapper.productResponseToProduct(product) }
    }

    private suspend fun getRecipeSteps(recipeId: Int): List<Step> {
        val stepsResponse = api.getRecipeSteps(recipeId)
        val steps = mutableListOf<Step>()
        for (step in stepsResponse.body()!!) {
            steps.add(StepMapper.stepResponseToStep(step))
        }
        return steps
    }

    private suspend fun getAvgRating(recipeId: Int): Double {
        val avgRatingResponse = api.getAvgRating(recipeId)
        return avgRatingResponse.body()!!
    }

    suspend fun getRecipeRatings(recipeId: Int): List<Rating> {
        val ratingResponse = api.getRecipeRatings(recipeId)
        return ratingResponse.body()!!
    }

    private suspend fun getRecipeComments(recipeId: Int): List<Comment> {
        val commentResponse = api.getRecipeComments(recipeId)
        return commentResponse.body()!!
    }

    fun getRecipe(recipeId: Int): Flow<Recipe> {
        return flow {
            println("--- before api")
            val recipeShort = getRecipeShort(recipeId)
            val nutritionalValue = getRecipeNutritionalValue(recipeId)
            val steps = getRecipeSteps(recipeId)
            val products = getRecipeProducts(recipeId)
            val avgRating = getAvgRating(recipeId)
            val ratings = getRecipeRatings(recipeId)
            val comments = getRecipeComments(recipeId)
            println("--- after api")
            val recipe =
                Recipe(recipeShort, nutritionalValue, steps, products, avgRating, ratings, comments)
            emit(recipe)
        }.flowOn(Dispatchers.IO)
    }
}