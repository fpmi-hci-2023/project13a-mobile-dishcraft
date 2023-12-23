package com.shinkevich.dishcraft.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.shinkevich.dishcraft.R

class ProductSearchResultAdapter (val productsList: List<String>) : RecyclerView.Adapter<ProductSearchResultAdapter.ProductSearchResultViewHolder> (){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductSearchResultViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product_search_result, parent, false)
        return ProductSearchResultViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductSearchResultViewHolder, position: Int) {
        holder.chip.text = productsList[position]
    }

    override fun getItemCount(): Int {
        return productsList.size
    }

    class ProductSearchResultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var chip: Chip

        init {
            chip = itemView.findViewById(R.id.productChip)
        }
    }
}