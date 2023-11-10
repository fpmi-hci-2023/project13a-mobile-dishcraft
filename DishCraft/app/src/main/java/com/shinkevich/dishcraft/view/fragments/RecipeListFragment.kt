package com.shinkevich.dishcraft.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.shinkevich.dishcraft.R
import com.shinkevich.dishcraft.databinding.FragmentRecipeListBinding
import com.shinkevich.dishcraft.view.adapters.RecipesAdapter
import com.shinkevich.dishcraft.view.adapters.itemDecoration.SpaceItemDecoration

class RecipeListFragment : Fragment() {
    private lateinit var binding: FragmentRecipeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecipeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerViews()
    }

    private fun initRecyclerViews(){
        val recipeList = List(20) { "" }
        binding.recipeListRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recipeListRecyclerView.addItemDecoration(SpaceItemDecoration(resources.getDimension(R.dimen.recipe_list_gap).toInt()))
        val recipesAdapter =
            RecipesAdapter(recipeList)
        binding.recipeListRecyclerView.adapter = recipesAdapter
    }
}