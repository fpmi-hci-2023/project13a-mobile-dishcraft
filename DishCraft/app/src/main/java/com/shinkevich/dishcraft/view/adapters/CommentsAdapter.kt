package com.shinkevich.dishcraft.view.adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shinkevich.dishcraft.R

class CommentsAdapter (var steps : List<String>) : RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_comment, parent, false)
        return CommentsAdapter.CommentsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return steps.size
    }

    class CommentsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}