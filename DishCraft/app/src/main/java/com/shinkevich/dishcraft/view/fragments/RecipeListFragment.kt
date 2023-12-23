package com.shinkevich.dishcraft.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.shinkevich.dishcraft.R
import com.shinkevich.dishcraft.databinding.FragmentRecipeListBinding
import com.shinkevich.dishcraft.view.adapters.RecipeListPagingAdapter
import com.shinkevich.dishcraft.view.adapters.itemDecoration.SpaceItemDecoration
import com.shinkevich.dishcraft.view.diffutil.RecipeListDiffCallback
import com.shinkevich.dishcraft.viewmodel.RecipeListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RecipeListFragment : Fragment() {
    private lateinit var binding: FragmentRecipeListBinding
    private val viewModel by viewModels<RecipeListViewModel>(
    )
    private val pagingAdapter = RecipeListPagingAdapter(RecipeListDiffCallback())

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

        lifecycleScope.launch {
            pagingAdapter.loadStateFlow.collectLatest { state ->
                if (state.refresh is LoadState.Loading) {
                    binding.loadingProgressBar.visibility = View.VISIBLE
                    binding.recipeListRecyclerView.visibility = View.GONE
                }
                if (state.refresh is LoadState.NotLoading) {
                    binding.loadingProgressBar.visibility = View.GONE
                    binding.recipeListRecyclerView.visibility = View.VISIBLE
                }
            }
        }
        viewModel.getRecipeList(true)

        binding.newBtn.setOnClickListener { viewModel.getRecipeList(true) }
        binding.popularBtn.setOnClickListener { viewModel.getRecipeList(false) }
    }

    private fun initRecyclerViews() {
        binding.recipeListRecyclerView.adapter = pagingAdapter
        binding.recipeListRecyclerView.setHasFixedSize(false)
        binding.recipeListRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recipeListRecyclerView.addItemDecoration(
            SpaceItemDecoration(
                resources.getDimension(
                    R.dimen.recipe_list_gap
                ).toInt()
            )
        )

        viewModel.recipeListLiveData.observe(this) { pagingData ->
            println("new data")
            lifecycleScope.launch {
                pagingAdapter.submitData(pagingData)
            }
        }


        /*val recipeList = List(20) { "" }
        binding.recipeListRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recipeListRecyclerView.addItemDecoration(SpaceItemDecoration(resources.getDimension(R.dimen.recipe_list_gap).toInt()))
        val recipesAdapter =
            RecipesAdapter(recipeList)
        binding.recipeListRecyclerView.adapter = recipesAdapter*/
    }

}