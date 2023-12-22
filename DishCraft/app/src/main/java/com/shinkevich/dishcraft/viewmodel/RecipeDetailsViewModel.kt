package com.shinkevich.dishcraft.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shinkevich.dishcraft.data.entity.Recipe
import com.shinkevich.dishcraft.data.networkstorage.entity.Comment
import com.shinkevich.dishcraft.data.networkstorage.entity.Rating
import com.shinkevich.dishcraft.data.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeDetailsViewModel @Inject constructor(private val recipeRepos: RecipeRepository) :
    ViewModel() {

    val recipeLiveData: MutableLiveData<Recipe> = MutableLiveData()

    /*private val _avgRatingLiveData = MutableLiveData<Double>()
    val avgRatingLiveData: LiveData<Double>
        get() = _avgRatingLiveData

    private val _ratingsLiveData = MutableLiveData<List<Rating>>()
    val ratingsLiveData: LiveData<List<Rating>>
        get() = _ratingsLiveData

    private val _commentsLiveData = MutableLiveData<List<Comment>>()
    val commentsLiveData: LiveData<List<Comment>>
        get() = _commentsLiveData*/

    fun getRecipe(recipeId: Int) {
        viewModelScope.launch {
            recipeRepos.getRecipe(recipeId).collect {
                recipeLiveData.postValue(it)
            }
        }
    }

    /*fun getAvgRating(recipeId: Int) {
        _loadsNum.postValue(loadsNum.value!! + 1)
        viewModelScope.launch {
            recipeRepos.getAvgRating(recipeId).collect {
                _avgRatingLiveData.postValue(it)
                _loadsNum.postValue(loadsNum.value!! - 1)
            }
        }
    }

    fun getRatings(recipeId: Int) {
        _loadsNum.postValue(loadsNum.value!! + 1)
        viewModelScope.launch {
            recipeRepos.getRecipeRatings(recipeId).collect {
                _ratingsLiveData.postValue(it)
                _loadsNum.postValue(loadsNum.value!! - 1)
            }
        }
    }

    fun getComments(recipeId: Int) {
        _loadsNum.postValue(loadsNum.value!! + 1)
        viewModelScope.launch {
            recipeRepos.getRecipeComments(recipeId).collect {
                _commentsLiveData.postValue(it)
                _loadsNum.postValue(loadsNum.value!! - 1)
            }
        }
    }*/
}