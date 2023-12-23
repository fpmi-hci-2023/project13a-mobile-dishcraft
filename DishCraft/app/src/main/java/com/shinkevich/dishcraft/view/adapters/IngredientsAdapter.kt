package com.shinkevich.dishcraft.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shinkevich.dishcraft.R
import com.shinkevich.dishcraft.data.entity.Product
import com.shinkevich.dishcraft.databinding.ItemIngredientBinding
import com.shinkevich.dishcraft.databinding.ItemRecipeBinding
import com.shinkevich.dishcraft.view.entity.RecipePreview

class IngredientsAdapter (private var ingredients  : List<Product>): RecyclerView.Adapter<IngredientsAdapter.IngredientsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientsViewHolder {
        val binding = ItemIngredientBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return IngredientsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IngredientsViewHolder, position: Int) {
        holder.bind(ingredients[position])
    }

    override fun getItemCount(): Int {
        return ingredients.size
    }

    class IngredientsViewHolder(private val itemBinding: ItemIngredientBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(product: Product) {
            itemBinding.productNameTV.text = product.productName
            if(product.image!=null){
                itemBinding.productImage.setImageBitmap(product.image)
            }
        }
    }
}