package com.shinkevich.dishcraft.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shinkevich.dishcraft.R

class StepsAdapter (var steps : List<String>) : RecyclerView.Adapter<StepsAdapter.StepsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StepsViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_step, parent, false)
        return StepsAdapter.StepsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: StepsViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return steps.size
    }

    class StepsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}