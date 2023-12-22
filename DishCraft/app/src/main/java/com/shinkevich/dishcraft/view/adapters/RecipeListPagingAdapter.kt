package com.shinkevich.dishcraft.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.shinkevich.dishcraft.R
import com.shinkevich.dishcraft.databinding.ItemRecipeBinding
import com.shinkevich.dishcraft.view.Utils
import com.shinkevich.dishcraft.view.entity.RecipePreview
import com.shinkevich.dishcraft.view.fragments.RecipeListFragmentDirections

class RecipeListPagingAdapter(diffCallback: DiffUtil.ItemCallback<RecipePreview>) :
    PagingDataAdapter<RecipePreview, RecipeListPagingAdapter.RecipeViewHolder>(diffCallback) {

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding = ItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(binding)
    }

    inner class RecipeViewHolder(private val itemRecipeBinding: ItemRecipeBinding) :
        RecyclerView.ViewHolder(itemRecipeBinding.root) {
        fun bind(recipe: RecipePreview?) {
            val context = itemRecipeBinding.root.context.applicationContext
            if (recipe != null) {
                itemRecipeBinding.recipeTitleTV.text = recipe.recipeName
                itemRecipeBinding.readyTimeTV.text =
                    Utils.showTime(recipe.readyTimeMinutes, context)
                itemRecipeBinding.readyTimeTV.text =
                    Utils.showTime(recipe.cookingTimeMinutes, context)
                itemRecipeBinding.complexityTV.text = recipe.complexity

                if(recipe.image!=null){
                    itemRecipeBinding.recipeImageImageView.setImageBitmap(recipe.image)
                }

                itemRecipeBinding.root.setOnClickListener{ itemView ->
                    val action =  RecipeListFragmentDirections.actionRecipeListFragmentToRecipeDetailsFragment(recipe.recipeId)
                    itemView.findNavController().navigate(action)
                //itemView.findNavController().navigate(R.id.recipeDetailsFragment)
                }

            }

        }
    }
}