package com.shinkevich.dishcraft.data.networkstorage.entity

import com.google.gson.annotations.SerializedName

data class RecipeResponse(

    @SerializedName("totalPages") var totalPages: Int,
    @SerializedName("totalElements") var totalElements: Int,
    @SerializedName("size") var size: Int,
    @SerializedName("content") var content: ArrayList<RecipeContent> = arrayListOf(),
    @SerializedName("number") var number: Int,
    @SerializedName("sort") var sort: Sort,
    @SerializedName("numberOfElements") var numberOfElements: Int,
    @SerializedName("pageable") var pageable: Pageable,
    @SerializedName("first") var first: Boolean,
    @SerializedName("last") var last: Boolean,
    @SerializedName("empty") var empty: Boolean

)

data class Roles(

    @SerializedName("id") var id: Int ,
    @SerializedName("name") var name: String 

)

data class Sort(

    @SerializedName("empty") var empty: Boolean ,
    @SerializedName("sorted") var sorted: Boolean ,
    @SerializedName("unsorted") var unsorted: Boolean 

)

data class Pageable(
    @SerializedName("offset") var offset: Int ,
    @SerializedName("sort") var sort: Sort,
    @SerializedName("pageNumber") var pageNumber: Int ,
    @SerializedName("pageSize") var pageSize: Int ,
    @SerializedName("paged") var paged: Boolean ,
    @SerializedName("unpaged") var unpaged: Boolean 
)