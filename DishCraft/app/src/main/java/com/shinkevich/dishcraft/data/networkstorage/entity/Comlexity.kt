package com.shinkevich.dishcraft.data.networkstorage.entity

import com.google.gson.annotations.SerializedName

data class Complexity(

    @SerializedName("complexityId") var complexityId: Int,
    @SerializedName("complexityName") var complexityName: String

)