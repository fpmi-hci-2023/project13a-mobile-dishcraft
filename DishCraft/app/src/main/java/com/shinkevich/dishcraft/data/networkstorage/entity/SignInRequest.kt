package com.shinkevich.dishcraft.data.networkstorage.entity

import com.google.gson.annotations.SerializedName

data class SignInRequest(
    @SerializedName("email") var email : String,
    @SerializedName("password") var password : String
) {}