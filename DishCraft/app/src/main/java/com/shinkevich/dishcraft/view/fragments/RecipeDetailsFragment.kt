package com.shinkevich.dishcraft.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.shinkevich.dishcraft.R
import com.shinkevich.dishcraft.databinding.FragmentRecipeDetailsBinding
import com.shinkevich.dishcraft.view.Utils
import com.shinkevich.dishcraft.view.adapters.CommentsAdapter
import com.shinkevich.dishcraft.view.adapters.IngredientsAdapter
import com.shinkevich.dishcraft.view.adapters.StepsAdapter
import com.shinkevich.dishcraft.view.adapters.itemDecoration.SpaceItemDecoration
import com.shinkevich.dishcraft.viewmodel.RecipeDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeDetailsFragment : Fragment() {
    private lateinit var binding: FragmentRecipeDetailsBinding
    private val args: RecipeDetailsFragmentArgs by navArgs()
    private val viewModel by viewModels<RecipeDetailsViewModel>()

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
        observeLiveData()
        viewModel.getRecipe(args.recipeId)
    }

    private fun initRecyclerViews() {
        binding.ingredientsRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        binding.stepsRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.stepsRecyclerView.addItemDecoration(
            SpaceItemDecoration(
                resources.getDimension(R.dimen.step_list_gap).toInt()
            )
        )
        val commentsList = List(5) { "" }
        binding.commentsRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.commentsRecyclerView.addItemDecoration(
            SpaceItemDecoration(
                resources.getDimension(R.dimen.comment_list_gap).toInt()
            )
        )

    }

    private fun observeLiveData() {
        /*viewModel.loadsNum.observe(this) {
            if (it == 0) {
                binding.screenContent.visibility = View.VISIBLE
                binding.loadingProgressBar.visibility = View.GONE
            } else {
                binding.screenContent.visibility = View.GONE
                binding.loadingProgressBar.visibility = View.VISIBLE
            }
        }

        viewModel.avgRatingLiveData.observe(this) {
            binding.avgMarkTV.text = Utils.showDouble(it)
        }

        viewModel.ratingsLiveData.observe(this) {
            binding.marksNumTV.text = it.size.toString()
        }

        viewModel.commentsLiveData.observe(this) {
            binding.commentsNumTV.text = it.size.toString()
        }*/

        viewModel.recipeLiveData.observe(this) { recipe ->
            binding.screenContent.visibility = View.VISIBLE
            binding.loadingProgressBar.visibility = View.GONE

            if (recipe.recipeShort!!.image != null) {
                binding.recipeImageView.setImageBitmap(recipe.recipeShort!!.image)
            }

            binding.recipeTitleTV.text = recipe.recipeShort!!.recipeName
            binding.recipeDescriptionTV.text = recipe.recipeShort!!.description
            binding.cookingTimeTV.text =
                Utils.showTime(recipe.recipeShort!!.cookingTimeMinutes, requireContext())
            binding.readyTimeTV.text =
                Utils.showTime(recipe.recipeShort!!.readyTimeMinutes, requireContext())
            binding.complexityTV.text = recipe.recipeShort!!.complexity

            binding.caloriesValueTV.text = Utils.showDouble(recipe.nutritionalValue!!.calories)
            binding.proteinsValueTV.text = Utils.showDouble(recipe.nutritionalValue!!.proteins)
            binding.fatsValueTV.text = Utils.showDouble(recipe.nutritionalValue!!.fats)
            binding.carbohydratesValueTV.text = Utils.showDouble(recipe.nutritionalValue!!.calories)

            binding.recipeAuthorNameTV.text = recipe.recipeShort!!.authorUsername

            val ingredientsAdapter =
                IngredientsAdapter(recipe.products)
            binding.ingredientsRecyclerView.adapter = ingredientsAdapter

            binding.stepsRecyclerView.adapter = StepsAdapter(recipe.steps)

            binding.avgMarkTV.text = Utils.showDoubleWithSeparator(recipe.avgRating)
            binding.marksNumTV.text = "(" + recipe.ratings.size.toString() + ")"
            binding.commentsNumTV.text = "(" + recipe.comments.size.toString() + ")"
            binding.ratingsTV.text =
                Utils.showDoubleWithSeparator(recipe.avgRating) + "   (" + recipe.ratings.size.toString() + ")"
            binding.ratingBar.rating = recipe.avgRating.toFloat()
            binding.commentsRecyclerView.adapter = CommentsAdapter(recipe.comments)
        }
    }

}