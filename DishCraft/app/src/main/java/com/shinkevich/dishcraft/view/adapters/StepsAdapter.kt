package com.shinkevich.dishcraft.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.res.stringResource
import androidx.recyclerview.widget.RecyclerView
import com.shinkevich.dishcraft.R
import com.shinkevich.dishcraft.data.entity.Product
import com.shinkevich.dishcraft.data.entity.Step
import com.shinkevich.dishcraft.databinding.ItemIngredientBinding
import com.shinkevich.dishcraft.databinding.ItemStepBinding

class StepsAdapter(var steps: List<Step>) : RecyclerView.Adapter<StepsAdapter.StepsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StepsViewHolder {
        val binding = ItemStepBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StepsAdapter.StepsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StepsViewHolder, position: Int) {
        holder.bind(steps[position])
    }

    override fun getItemCount(): Int {
        return steps.size
    }

    class StepsViewHolder(private val itemBinding: ItemStepBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(step: Step) {
            if (step.image != null) {
                itemBinding.recipeStepPhoto.setImageBitmap(step.image)
            }
            itemBinding.recipeStepDescription.text = step.stepDescription
            itemBinding.recipeStepNumber.text =
                itemBinding.root.context.getString(R.string.step) + " " + step.numberInRecipe
        }
    }
}