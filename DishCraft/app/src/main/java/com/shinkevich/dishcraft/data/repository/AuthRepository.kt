package com.shinkevich.dishcraft.data.repository

import com.shinkevich.dishcraft.data.entity.UserCredentials
import com.shinkevich.dishcraft.data.networkstorage.AuthService
import javax.inject.Inject

class AuthRepository @Inject constructor(private val authService: AuthService, private val tokenRepos: TokenRepository) {
    suspend fun signin(credentials: UserCredentials): Boolean {
        val token = authService.signin(credentials) ?: return false
        tokenRepos.saveToken(token)
        return true
    }
}