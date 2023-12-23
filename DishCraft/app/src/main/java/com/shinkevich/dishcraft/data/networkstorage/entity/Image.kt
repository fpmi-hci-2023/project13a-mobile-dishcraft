package com.shinkevich.dishcraft.data.networkstorage.entity

import com.google.gson.annotations.SerializedName

data class Image(

    @SerializedName("id") var id: Int,
    @SerializedName("data") var data: String,
    @SerializedName("fileName") var fileName: String,
    @SerializedName("fileType") var fileType: String,
    @SerializedName("systemName") var systemName: String

)