package com.shinkevich.dishcraft.data.entity

data class Page<T>(var content: List<T>, var nextPage: Int?) {
}