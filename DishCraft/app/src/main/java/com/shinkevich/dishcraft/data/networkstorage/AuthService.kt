package com.shinkevich.dishcraft.data.networkstorage

import com.shinkevich.dishcraft.data.entity.UserCredentials
import com.shinkevich.dishcraft.data.networkstorage.api.AuthApi
import com.shinkevich.dishcraft.data.networkstorage.entity.SignInRequest
import javax.inject.Inject

class AuthService @Inject constructor(private val authApi: AuthApi) {
    suspend fun signin(userCredentials: UserCredentials): String? {
        try {
            val signinResponse =
                authApi.signin(SignInRequest(userCredentials.email, userCredentials.password))
            return if (signinResponse.isSuccessful) {
                signinResponse.body()!!.token
            } else {
                null
            }
        } catch (exc: Exception) {
            return null
        }
    }
}