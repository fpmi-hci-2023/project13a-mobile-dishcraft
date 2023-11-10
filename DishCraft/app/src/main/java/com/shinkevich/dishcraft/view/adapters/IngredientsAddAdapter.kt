package com.shinkevich.dishcraft.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.shinkevich.dishcraft.R
import com.shinkevich.dishcraft.databinding.ItemIngredientAddBinding

class IngredientsAddAdapter(var ingredients  : List<String>): RecyclerView.Adapter<IngredientsAddAdapter.IngredientsAddViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientsAddViewHolder {
        val binding = ItemIngredientAddBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return IngredientsAddViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IngredientsAddViewHolder, position: Int) {
        val adapter = ArrayAdapter.createFromResource(holder.binding.root.context, R.array.measure_units, R.layout.spinner_measure_units )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        holder.binding.measureUnitSpinner.adapter = adapter
        holder.binding.measureUnitSpinner.setSelection(1)
    }

    override fun getItemCount(): Int {
        return ingredients.size
    }

    inner class IngredientsAddViewHolder(val binding: ItemIngredientAddBinding) : RecyclerView.ViewHolder(binding.root) {
    }
}