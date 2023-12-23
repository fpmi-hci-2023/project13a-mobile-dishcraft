package com.shinkevich.dishcraft.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.shinkevich.dishcraft.data.entity.Recipe
import com.shinkevich.dishcraft.data.entity.RecipeShort
import com.shinkevich.dishcraft.data.networkstorage.NetworkRecipeStorage
import com.shinkevich.dishcraft.data.networkstorage.entity.Comment
import com.shinkevich.dishcraft.data.networkstorage.entity.Rating
import com.shinkevich.dishcraft.data.paging.RecipePagingSource
import com.shinkevich.dishcraft.data.paging.RecipePagingSourceFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RecipeRepository @Inject constructor(
    //private val recipePagingSource: RecipePagingSource,
    private val recipePagingSourceFactory:RecipePagingSourceFactory,
    private val networkStorage: NetworkRecipeStorage
) {
    fun getRecipeListPage(showNew :  Boolean = true): Flow<PagingData<RecipeShort>> {
        return Pager(
            config = PagingConfig(pageSize = 10, prefetchDistance = 5),
            pagingSourceFactory = {
                //recipePagingSource
                recipePagingSourceFactory.create(showNew)
            }
        ).flow
            .flowOn(Dispatchers.IO)
    }

    fun getRecipe(recipeId: Int): Flow<Recipe> {
        return networkStorage.getRecipe(recipeId)
    }
}