package com.shinkevich.dishcraft.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shinkevich.dishcraft.data.entity.UserCredentials
import com.shinkevich.dishcraft.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authRepos: AuthRepository) : ViewModel() {
    private val _isAuthenticated = MutableLiveData<Boolean>()
    val isAuthenticated: LiveData<Boolean>
        get() = _isAuthenticated

    fun signin(email: String, password: String) {
        viewModelScope.launch {
            val isAuthenticated = authRepos.signin(UserCredentials(email, password))
            _isAuthenticated.postValue(isAuthenticated)
        }
    }
}