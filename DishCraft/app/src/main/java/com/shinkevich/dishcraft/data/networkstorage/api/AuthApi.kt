package com.shinkevich.dishcraft.data.networkstorage.api

import com.shinkevich.dishcraft.data.networkstorage.entity.SignInRequest
import com.shinkevich.dishcraft.data.networkstorage.entity.SignInResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("/auth/signin")
    suspend fun signin(@Body signinRequest : SignInRequest) : Response<SignInResponse>
}