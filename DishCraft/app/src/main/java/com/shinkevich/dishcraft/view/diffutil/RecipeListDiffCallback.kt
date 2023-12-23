package com.shinkevich.dishcraft.view.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.shinkevich.dishcraft.view.entity.RecipePreview

class RecipeListDiffCallback : DiffUtil.ItemCallback<RecipePreview>() {
    override fun areItemsTheSame(oldItem: RecipePreview, newItem: RecipePreview) =
        oldItem.recipeId == newItem.recipeId

    override fun areContentsTheSame(
        oldItem: RecipePreview,
        newItem: RecipePreview
    ) : Boolean {
        return oldItem.recipeName == newItem.recipeName &&
                oldItem.cookingTimeMinutes == newItem.cookingTimeMinutes &&
                oldItem.readyTimeMinutes == newItem.readyTimeMinutes &&
                oldItem.complexity == newItem.complexity
    }

    override fun getChangePayload(oldItem: RecipePreview, newItem: RecipePreview): Any? {
        if (oldItem != newItem) {
            return newItem
        }
        return super.getChangePayload(oldItem, newItem)
    }
}