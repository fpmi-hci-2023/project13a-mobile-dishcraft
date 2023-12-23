package com.shinkevich.dishcraft.data.networkstorage.entity

import com.google.gson.annotations.SerializedName

data class SignUpRequest (
    @SerializedName("username") var username : String,
    @SerializedName("email") var email : String,
    @SerializedName("password") var password : String,
    @SerializedName("role") var role : List<String>
){}