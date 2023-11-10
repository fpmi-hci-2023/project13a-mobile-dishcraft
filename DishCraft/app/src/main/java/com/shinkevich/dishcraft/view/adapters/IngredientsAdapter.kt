package com.shinkevich.dishcraft.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shinkevich.dishcraft.R

class IngredientsAdapter (var ingredients  : List<String>): RecyclerView.Adapter<IngredientsAdapter.IngredientsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientsViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_ingredient, parent, false)
        return IngredientsAdapter.IngredientsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: IngredientsViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return ingredients.size
    }

    class IngredientsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}