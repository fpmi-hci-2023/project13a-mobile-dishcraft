package com.shinkevich.dishcraft.data.networkstorage.api

import com.shinkevich.dishcraft.data.networkstorage.entity.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeApi {
    @GET("/recipes")
    suspend fun getRecipes(@Query("page") query : Int, @Query("sortBy") sortBy : String? = null) : Response<RecipeResponse>

    @GET("/recipes/{id}")
    suspend fun getRecipe(@Path("id") id : Int) : Response<RecipeContent>

    @GET("/recipes/{id}/nutritional_value")
    suspend fun getRecipeNutritionalValue(@Path("id") id : Int) : Response<NutritionalValueResponse>

    @GET("/recipes/{id}/steps")
    suspend fun getRecipeSteps(@Path("id") id : Int) : Response<List<StepsResponse>>

    @GET("/recipes/{id}/image")
    suspend fun getRecipeImage(@Path("id") id : Int) : Response<String>

    @GET("/recipes/{id}/products")
    suspend fun getRecipeProducts(@Path("id") id : Int) : Response<List<Product>>

    @GET("/recipes/{id}/ratings/total")
    suspend fun getAvgRating(@Path("id") id : Int) : Response<Double>

    @GET("/recipes/{id}/ratings")
    suspend fun getRecipeRatings(@Path("id") id : Int) : Response<List<Rating>>

    @GET("/recipes/{id}/comments")
    suspend fun getRecipeComments(@Path("id") id : Int) : Response<List<Comment>>


}