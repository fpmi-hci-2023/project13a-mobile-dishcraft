package com.shinkevich.dishcraft.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shinkevich.dishcraft.R

class StepsAddAdapter (var steps : List<String>) : RecyclerView.Adapter<StepsAddAdapter.StepsAddViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StepsAddViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_step_add, parent, false)
        return StepsAddAdapter.StepsAddViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: StepsAddViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return steps.size
    }

    class StepsAddViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}