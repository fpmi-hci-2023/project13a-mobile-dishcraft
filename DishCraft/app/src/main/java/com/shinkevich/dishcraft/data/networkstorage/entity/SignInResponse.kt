package com.shinkevich.dishcraft.data.networkstorage.entity

import com.google.gson.annotations.SerializedName

data class SignInResponse(
    @SerializedName("email") var email : String,
    @SerializedName("token") var token : String
){}