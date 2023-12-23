package com.shinkevich.dishcraft.data.paging

import dagger.assisted.AssistedFactory

@AssistedFactory
interface RecipePagingSourceFactory {
    fun create(showNew : Boolean): RecipePagingSource
}