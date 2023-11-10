package com.shinkevich.dishcraft.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.shinkevich.dishcraft.R
import com.shinkevich.dishcraft.databinding.FragmentRecipeDetailsBinding
import com.shinkevich.dishcraft.view.adapters.*
import com.shinkevich.dishcraft.view.adapters.itemDecoration.SpaceItemDecoration

class RecipeDetailsFragment : Fragment() {
    private lateinit var binding: FragmentRecipeDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecipeDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerViews()
    }

    private fun initRecyclerViews(){
        val ingredientsList = List(5) { "" }
        binding.ingredientsRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val ingredientsAdapter =
            IngredientsAdapter(ingredientsList)
        binding.ingredientsRecyclerView.adapter = ingredientsAdapter

        val stepsList = List(5) {""}
        binding.stepsRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.stepsRecyclerView.adapter = StepsAdapter(stepsList)
        binding.stepsRecyclerView.addItemDecoration(SpaceItemDecoration(resources.getDimension(R.dimen.step_list_gap).toInt()))

        val commentsList = List(5) {""}
        binding.commentsRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.commentsRecyclerView.adapter = CommentsAdapter(commentsList)
        binding.commentsRecyclerView.addItemDecoration(SpaceItemDecoration(resources.getDimension(R.dimen.comment_list_gap).toInt()))

    }
}