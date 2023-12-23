package com.shinkevich.dishcraft.data.networkstorage.entity

import com.google.gson.annotations.SerializedName

data class User(

    @SerializedName("id") var id: Int,
    @SerializedName("username") var username: String,
    @SerializedName("email") var email: String,
    @SerializedName("roles") var roles: ArrayList<Roles> = arrayListOf()

)