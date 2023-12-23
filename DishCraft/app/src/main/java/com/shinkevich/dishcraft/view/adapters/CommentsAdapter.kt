package com.shinkevich.dishcraft.view.adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shinkevich.dishcraft.R
import com.shinkevich.dishcraft.data.entity.Product
import com.shinkevich.dishcraft.data.networkstorage.entity.Comment
import com.shinkevich.dishcraft.databinding.ItemCommentBinding
import com.shinkevich.dishcraft.databinding.ItemIngredientBinding
import com.shinkevich.dishcraft.view.Utils

class CommentsAdapter (var comments : List<Comment>) : RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        val binding = ItemCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommentsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        holder.bind(comments[position])
    }

    override fun getItemCount(): Int {
        return comments.size
    }

    class CommentsViewHolder(private val itemBinding: ItemCommentBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(comment: Comment) {
            itemBinding.commentTextTV.text = comment.commentText
            itemBinding.dateTV.text = Utils.formatDate(comment.commentDate)
            itemBinding.commentAuthorTV.text=comment.user.username
        }
    }
}