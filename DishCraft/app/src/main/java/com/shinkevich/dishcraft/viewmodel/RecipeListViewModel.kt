package com.shinkevich.dishcraft.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.shinkevich.dishcraft.data.repository.RecipeRepository
import com.shinkevich.dishcraft.view.entity.RecipePreview
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository
) : ViewModel() {
    private val _recipeListLiveData = MutableLiveData<PagingData<RecipePreview>>()
    val recipeListLiveData: LiveData<PagingData<RecipePreview>>
        get() = _recipeListLiveData

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun getRecipeList(new : Boolean = true) {
        _isLoading.postValue(true)
        viewModelScope.launch {
            recipeRepository.getRecipeListPage(new)
                .map { pagingData ->
                    pagingData.map { recipe ->
                        RecipePreview(
                            recipe.recipeId,
                            recipe.recipeName,
                            recipe.cookingTimeMinutes,
                            recipe.readyTimeMinutes,
                            recipe.complexity,
                            recipe.image
                        )
                    }
                }
                .cachedIn(viewModelScope)
                .collectLatest {
                    _recipeListLiveData.postValue(it)
                }
        }
    }

    fun searchRecipes(query:String){

    }

}