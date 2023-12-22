package com.shinkevich.dishcraft.data.networkstorage.entity

import com.google.gson.annotations.SerializedName

data class Comment(

    @SerializedName("commentId") var commentId: Int,
    @SerializedName("commentText") var commentText: String,
    @SerializedName("commentDate") var commentDate: String,
    @SerializedName("user") var user: User,
    @SerializedName("recipe") var recipe: RecipeContent

)