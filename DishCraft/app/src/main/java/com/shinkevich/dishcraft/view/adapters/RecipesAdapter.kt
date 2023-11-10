package com.shinkevich.dishcraft.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.shinkevich.dishcraft.R
import com.shinkevich.dishcraft.view.fragments.RecipeListFragmentDirections

class RecipesAdapter (var recipes : List<String>) : RecyclerView.Adapter<RecipesAdapter.RecipesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recipe, parent, false)
        return RecipesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecipesViewHolder, position: Int) {
        holder.itemView.setOnClickListener{
            val actionToRecipeDetails = RecipeListFragmentDirections.actionRecipeListFragmentToRecipeDetailsFragment(1)
            holder.itemView.findNavController().navigate(actionToRecipeDetails)
        }
    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    class RecipesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}