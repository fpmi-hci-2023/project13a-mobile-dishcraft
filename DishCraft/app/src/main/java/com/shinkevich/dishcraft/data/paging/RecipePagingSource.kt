package com.shinkevich.dishcraft.data.paging

import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.shinkevich.dishcraft.data.entity.RecipeShort
import com.shinkevich.dishcraft.data.networkstorage.NetworkRecipeStorage
import com.shinkevich.dishcraft.exception.NetworkException
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import javax.inject.Inject

class RecipePagingSource @AssistedInject constructor(
    private val recipeStorage: NetworkRecipeStorage,
    @Assisted private val showNew: Boolean
) : PagingSource<Int, RecipeShort>() {

    override fun getRefreshKey(state: PagingState<Int, RecipeShort>): Int? {
        // Try to find the page key of the closest page to anchorPosition from
        // either the prevKey or the nextKey; you need to handle nullability
        // here.
        //  * prevKey == null -> anchorPage is the first page.
        //  * nextKey == null -> anchorPage is the last page.
        //  * both prevKey and nextKey are null -> anchorPage is the
        //    initial page, so return null.
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RecipeShort> {
        try {
            val nextPageNumber = params.key ?: 0
            val recipesPage = recipeStorage.getRecipes(nextPageNumber)
            return LoadResult.Page(
                data = recipesPage.content,
                prevKey = null,
                nextKey = recipesPage.nextPage
            )
        } catch (exc: Exception) {
            return LoadResult.Error(NetworkException())
        }
    }
}